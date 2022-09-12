package com.manisha.controller;

import com.manisha.entity.Order;
import com.manisha.entity.Status;
import com.manisha.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private OrderStatusService statusService;



    @GetMapping("/allById")
    public Status getStatusById(@RequestParam("id") int id){

        return statusService.findById(id);
    }


    @GetMapping("/all")
    public List<Status> getStatusDetails() {

        return statusService.getAllOrderStatus();
    }


}
