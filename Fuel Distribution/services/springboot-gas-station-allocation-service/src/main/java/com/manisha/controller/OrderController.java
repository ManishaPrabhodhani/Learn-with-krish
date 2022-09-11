package com.manisha.controller;

import com.manisha.entity.Order;
import com.manisha.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        return orders;
    }

    @PostMapping("/save")
    public Order saveOrders(@RequestBody Order order) {
        order = orderRepository.save(order);
        return order;
    }
}
