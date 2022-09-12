package com.manisha.config;

import com.google.gson.Gson;
import com.manisha.entity.Order;
import com.manisha.entity.Status;
import com.manisha.event.Event;
import com.manisha.service.OrderService;
import com.manisha.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class DispatchConsumer {

    @Autowired
    private OrderStatusService statusService;

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "new connection", groupId = "order-group")
    public void read(String message) {

        Event event = new Gson().fromJson(message, Event.class);

        if (event.getServiceName().equals("DispatchService") && event.getType().equals("Complete Dispatch") && event.getOutcome().equals("SUCCESSFUL")) {

            List<Status> list = statusService.getAllOrderStatus();
            for (Status st : list) {
                if (st.getOrderId() == Integer.parseInt(event.getOrderid())) {
                    Status status = new Status();
                    status.setStatusId(st.getStatusId());
                    status.setOrderId(st.getOrderId());
                    status.setAllocationStatus(st.getAllocationStatus());
                    status.setDispatchStatus(event.getOutcome());
                    status.setScheduleStatus(st.getScheduleStatus());

                    statusService.createStatus(status);
                }
            }
        }


    }

}
