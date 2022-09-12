package com.manisha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dispatch_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispatch {
    @Id
    @GeneratedValue
    private int dispatchId;
    private int orderId;
    private String stationRegNo;
    private String status;


}
