package com.manisha.event;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {


    private String serviceName;
    private String Type;
    private String uniqueId;    //key
    private String fuelQty;
    private String orderid;
    private String stockid;
    private String outcome;   //result


}
