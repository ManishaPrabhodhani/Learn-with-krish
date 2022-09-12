package com.manisha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private int orderId;
    private String fuelStationRegNo;
    private String fuelStationName;
    private String address;
    private String contactNo;
    private String fuelType;
    private double fuelQty;
    private Date scheduleDate;
  
    @Temporal(TemporalType.DATE)
    private Date date =  new Date(System.currentTimeMillis());


}
