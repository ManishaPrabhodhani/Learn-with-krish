package com.manisha.service;

import com.manisha.entity.Stock;
import com.manisha.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StockService {
    @Autowired
    private StockRepository stockRepository;


    public Optional<Stock> get(int id) {

        return stockRepository.findById(id);
    }

    public Stock save(Stock stock) {
        return stockRepository.save(stock);

    }


    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

}
