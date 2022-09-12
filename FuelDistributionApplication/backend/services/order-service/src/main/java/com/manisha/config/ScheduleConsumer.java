package com.manisha.config;

import com.google.gson.Gson;
import com.manisha.entity.Order;
import com.manisha.entity.Schedule;
import com.manisha.entity.Status;
import com.manisha.event.Event;
import com.manisha.event.ScheduleEvent;
import com.manisha.service.OrderService;
import com.manisha.service.OrderStatusService;
import com.manisha.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleConsumer {

    @Autowired
    private OrderStatusService statusService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ScheduleService scheduleService;

    @KafkaListener(topics = "schedule-response", groupId = "order-group")
    public void read(String message) {
        ScheduleEvent event = new Gson().fromJson(message, ScheduleEvent.class);

        if (event.getServiceName().equals("ScheduleService") && event.getType().equals("Complete Schedule") && event.getOutcome().equals("SUCCESSFUL")) {

            List<Status> list=statusService.getAllOrderStatus();
            List<Order> orderList= orderService.getAllOrders();
            for(Status st :list){
                if(st.getOrderId()==Integer.parseInt(event.getOrderid())){
                    Status status=new Status();
                    status.setStatusId(st.getStatusId());
                    status.setOrderId(st.getOrderId());
                    status.setAllocationStatus(event.getOutcome());
                    status.setDispatchStatus(st.getDispatchStatus());
                    status.setScheduleStatus("SUCCESSFUL");

                    statusService.createStatus(status);
                }
            }

            Schedule schedule = new Schedule();
            schedule.setOrderId(Integer.parseInt(event.getOrderid()));
            schedule.setDate(event.getDate());
            scheduleService.createSchedule(schedule);

        }

    }
}

