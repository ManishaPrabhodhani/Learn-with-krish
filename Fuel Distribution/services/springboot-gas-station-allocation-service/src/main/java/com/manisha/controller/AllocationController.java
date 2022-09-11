package com.manisha.controller;

import com.manisha.entity.Allocation;
import com.manisha.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/allocation")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @PostMapping(value = "/create")
    public Allocation createAllocations(@RequestBody Allocation allocation) {

        allocation=allocationService.createAllocations(allocation);
        return allocation;
    }

    @GetMapping("/all")
    public List<Allocation> getAllocationDetails() {

        return allocationService.getAllAllocations();
    }
}
