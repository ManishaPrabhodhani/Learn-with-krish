package com.manisha.controller;


import com.manisha.dto.OrderDetails;
import com.manisha.entity.Order;
import com.manisha.config.Producer;
import com.manisha.entity.Status;
import com.manisha.service.OrderService;
import com.manisha.service.OrderStatusService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
   private OrderStatusService statusService;

    @Autowired
   private Producer producer;


    @PostMapping("/create")
    public  Order create(@RequestBody Order order){

     // producer.publish(new Event("order service", "New Order",String.valueOf(order.getOrderId()),String.valueOf(order.getOrderId()),"PENDING"));
        Status status=new Status();
        status.setOrderId(order.getOrderId());
        status.setAllocationStatus("PENDING");
        status.setScheduleStatus("PENDING");
        status.setDispatchStatus("PENDING");
        statusService.createStatus(status);
        log.info("ORDER SAVED SUCCESSFULLY");
        log.info("STATUS SAVED SUCCESSFULLY");
        return orderService.createOrder(order);


    }

    @GetMapping("/all")
    public List<Order> getOrderDetails() {

        return orderService.getAllOrders();
    }

    @GetMapping("/dispatchOrders")
    public List<OrderDetails> getAllDispatchedOrders(){

       return orderService.findDispatchOrderDetails();
    }

    @GetMapping("/fuelStationOrders")
    public List<OrderDetails> GetAllOrdersByStationRegNo(@RequestParam("id") String id){

        return orderService.findOrderByStationRegNo(id);
    }
}
