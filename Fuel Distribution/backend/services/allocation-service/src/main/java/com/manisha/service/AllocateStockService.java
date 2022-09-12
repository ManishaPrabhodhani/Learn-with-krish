package com.manisha.service;

import com.manisha.entity.Allocation;
import com.manisha.repository.AllocateStockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AllocateStockService {

    Logger logger = LoggerFactory.getLogger(AllocateStockService.class);

    @Autowired
    private AllocateStockRepository allocateStockRepository;


    public Allocation save(Allocation allocateStock){
        return allocateStockRepository.save(allocateStock);
    }

    public List<Allocation> getAllocateStock() {
        return allocateStockRepository.findAll();
    }

    public int allocatedFuelOrder() {
        int allocatedOrder =0;
        List<Allocation> allocations =  allocateStockRepository.findAll();
        for (Allocation allocation: allocations){
             allocatedOrder += allocation.getFuelQty();
        }
        logger.info("Allocated Order Value " + allocatedOrder );
        return allocatedOrder;

    }

    public void delete(int id) {
        allocateStockRepository.deleteById(id);


    }


}
