package com.manisha.controller;

import com.manisha.entity.Allocation;
import com.manisha.entity.Dispatch;
import com.manisha.entity.Stock;
import com.manisha.config.DispatchProducer;
import com.manisha.service.AllocateStockService;
import com.manisha.service.DispatchService;
import com.manisha.service.StockService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dispatch")
@Transactional
public class DispatchController {

    Logger logger = LoggerFactory.getLogger(DispatchController.class);

    @Autowired
    private DispatchService dispatchService;

    @Autowired
    private StockService stockService;

    @Autowired
    private AllocateStockService allocateStockService;

    @Autowired
    private DispatchProducer dispatchProducer;


    @PostMapping("/save")
    public Dispatch createDispatch(@RequestBody Dispatch dispatch) {
        List<Allocation> allocateStock = allocateStockService.getAllocateStock();
        for (Allocation stock : allocateStock) {
            if (stock.getId() == dispatch.getOrderId()) {
                logger.info("ID IS NOT VALID");

                Optional<Stock> stockOptional = stockService.get(Integer.parseInt(stock.getStockId()));
                double availableFuelStock = stockOptional.get().getAvailableStock();
                double dispatchFuelQty = stock.getFuelQty();
                double remainFuelStock = availableFuelStock - dispatchFuelQty;


                // update fuel stock
                Stock updatedFuelStock = new Stock();
                updatedFuelStock.setStockId(stockOptional.get().getStockId());
                updatedFuelStock.setFuelType(stockOptional.get().getFuelType());
                updatedFuelStock.setAvailableStock(remainFuelStock);
                stockService.save(updatedFuelStock);
                //dispatchProducer.TopicPublisher(new Event("Dispatch", "complete_dispatch", String.valueOf(dispatch.getOrderId()), "", String.valueOf(dispatch.getOrderId()), String.valueOf(stockOptional.get().getStockId()), "Success"));
               }

        }
        return dispatchService.save(dispatch);
    }

        @GetMapping(value = "/all")
        public List<Dispatch> getDispatchDetails() {

            return dispatchService.getAllDispatch();
        }


        @PutMapping("/update")
        public Dispatch updateDispatch(@RequestBody Dispatch dispatch){
            List<Dispatch> list = dispatchService.getAllDispatch();
            Dispatch dispatch1 = new Dispatch();
            for (Dispatch d : list) {
                if (d.getOrderId() == dispatch.getOrderId()) {
                    dispatch1.setDispatchId(d.getDispatchId());
                    dispatch1.setOrderId(d.getOrderId());
                    dispatch1.setStatus("SUCCESSFULLY RECEIVED");
                    dispatch1.setStationRegNo(d.getStationRegNo());
                }
            }
            return dispatchService.save(dispatch);
    }

}






