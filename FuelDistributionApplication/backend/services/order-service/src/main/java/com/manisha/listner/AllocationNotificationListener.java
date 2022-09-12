package com.manisha.listner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manisha.entity.Allocation;
import com.manisha.entity.Order;
import com.manisha.repository.AllocationRepository;
import com.manisha.repository.OrderRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class AllocationNotificationListener {

    Logger logger = LoggerFactory.getLogger(AllocationNotificationListener.class);

    @Value("${order.topic.name}")
    private String topicName;

    ObjectMapper objectMapper =new ObjectMapper();
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AllocationRepository allocationRepository;

    @KafkaListener(topics = "order-topic", groupId = "GroupID-1")
    public void processOrder(String message) {
        logger.info("Received Message-> " + message);
        Allocation allocation = null;
        try {
            allocation = objectMapper.readValue(message, Allocation.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Order order=orderRepository.findById(allocation.getOrderId()).get();
        if (order.getOrderFuelQty() < allocation.getFuelStock()) {
            allocation.setStatus("ALLOCATION SUCCESS");
            allocationRepository.save(allocation);

        } else {
            allocation.setStatus("ALLOCATION FAILED");
            allocationRepository.save(allocation);

        }

    }
}
