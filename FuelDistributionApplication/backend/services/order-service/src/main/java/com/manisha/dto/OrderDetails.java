package com.manisha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {

    private int orderId;
    private String fuelStationRegNo;
    private String fuelStationName;;
    private String address;
    private String contactNo;
    private String fuelType;
    private double fuelQty;
    private String allocationStatus;
    private String scheduleDate;
    private String scheduleStatus;
    private String dispatchStatus;
}
