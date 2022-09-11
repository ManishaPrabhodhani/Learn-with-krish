package com.manisha.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "allocation_tbl")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor

public class Allocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int allocationId;
    private int orderId;
    private double fuelStock;
    private String status;






}
