package com.manisha.config;

import com.google.gson.Gson;
import com.manisha.entity.Status;
import com.manisha.event.Event;
import com.manisha.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Consumer {

    @Autowired
    private OrderStatusService statusService;

    @Autowired
    private Producer producer;

    @KafkaListener(topics = "order-response", groupId = "order-group")
    public void read(String message) {
        Event event = new Gson().fromJson(message, Event.class);
        if(event.getServiceName().equals("AllocationService") && event.getType().equals("Complete Allocation")){
            if(event.getOutcome().equals("SUCCESSFUL")){
                List<Status> list=statusService.getAllOrderStatus();
                for(Status st :list){
                    if(st.getOrderId()==Integer.parseInt(event.getOrderid())){
                       Status status=new Status();
                        status.setStatusId(st.getStatusId());
                        status.setOrderId(st.getOrderId());
                        status.setAllocationStatus("SUCCESSFUL");
                        status.setDispatchStatus(st.getDispatchStatus());
                        status.setScheduleStatus(st.getScheduleStatus());

                        statusService.createStatus(status);
                    }
                }
            }

            }

        }

}
