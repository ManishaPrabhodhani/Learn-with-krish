package com.manisha.config;

import com.google.gson.Gson;
import com.manisha.entity.Allocation;
import com.manisha.entity.Stock;
import com.manisha.event.Event;
import com.manisha.service.AllocateStockService;
import com.manisha.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Consumer {

    Logger logger = LoggerFactory.getLogger(Consumer.class);
    @Autowired
    private AllocateStockService allocateStockService;

    @Autowired
    private StockService stockService;

    @Autowired
    private Producer producer;

    @Autowired
    private ScheduleProducer scheduleProducer;

    @KafkaListener(topics = "order-topic", groupId = "order-group")

    public void readMessages(String message) {
        Event event = new Gson().fromJson(message, Event.class);
        if (event.getType().equals("CreateNewOrder")) {
            Optional<Stock> stock = stockService.get(Integer.parseInt(event.getStockid()));

            if (stock.isPresent()) {
                double orderQty = Double.parseDouble(event.getFuelQty());
                double availableQty = stock.get().getAvailableStock();
                if (availableQty >= orderQty) {
                    if (availableQty >= allocateStockService.allocatedFuelOrder() + orderQty) {


                        Allocation allocation = new Allocation();
                        allocation.setId(Integer.parseInt(event.getOrderid()));
                        allocation.setFuelQty(Double.parseDouble(event.getFuelQty()));
                        allocation.setStockId(event.getStockid());
                        allocateStockService.save(allocation);
                        logger.info("ALLOCATION SUCCESSFUL");

                        producer.publish(new Event("Allocation_service", "Allocation_Complete", event.getUniqueId(), event.getFuelQty(), event.getOrderid(), event.getStockid(), "SUCCESSFUL"));
                        scheduleProducer.publish(new Event("Allocation_service", "Allocation_Complete", event.getUniqueId(), event.getFuelQty(), event.getOrderid(), event.getStockid(), "SUCCESSFUL"));
                    } else {
                        logger.info("NO STOCK AVAILABLE");
                    }

                }


            }


        }
    }
}
