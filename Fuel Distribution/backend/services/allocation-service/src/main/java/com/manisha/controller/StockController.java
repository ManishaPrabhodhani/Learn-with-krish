package com.manisha.controller;

import com.manisha.entity.Stock;
import com.manisha.objectentity.StockEntity;
import com.manisha.service.AllocateStockService;
import com.manisha.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    private AllocateStockService allocateStockService;

    @GetMapping("/all")
    public List<StockEntity> getStockDetails() {
        List<StockEntity> stockList = new ArrayList<>();
        List<Stock> stock = stockService.getAllStock();

        for (Stock st : stock) {
            StockEntity stockEntity = new StockEntity();
            stockEntity.setStockId(st.getStockId());
            stockEntity.setFuelType(st.getFuelType());
            stockEntity.setAvailableStock(st.getAvailableStock());
            stockList.add(stockEntity);
        }
        return stockList;
    }
}