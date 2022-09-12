package com.manisha.objectentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity {

    private int stockId;
    private String fuelType;
    private double availableStock;

}
