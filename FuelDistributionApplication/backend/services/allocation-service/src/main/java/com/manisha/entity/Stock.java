package com.manisha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Stock {

    @Id
    private int stockId;
    private String fuelType;
    private double availableStock;
}
