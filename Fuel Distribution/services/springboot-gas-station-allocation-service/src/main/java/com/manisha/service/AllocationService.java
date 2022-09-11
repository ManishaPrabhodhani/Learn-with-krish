package com.manisha.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manisha.entity.Allocation;
import com.manisha.entity.Order;
import com.manisha.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    @Autowired
    AllocationRepository allocationRepository;

    @Value("${order.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    Order order= new Order();

    ObjectMapper objectMapper=new ObjectMapper();

    public Allocation createAllocations(Allocation allocation) {
        allocation =allocationRepository.save(allocation);
        allocation.setStatus("PENDING");
        // after saving Order lets release message for Allocation service
        String message= null;
        try {
            message = objectMapper.writeValueAsString(allocation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topicName,message);
        return allocation;
    }

    public List<Allocation> getAllAllocations() {
        List<Allocation> allocation= (List<Allocation>) allocationRepository.findAll();
        return allocation;
    }
}
