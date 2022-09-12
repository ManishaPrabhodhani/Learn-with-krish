package com.manisha.event;


import lombok.Data;

@Data
public class Event {


    private String serviceName;
    private String Type;
    private String uniqueId;
    private String fuelQty;
    private String orderid;

    private String stockid;
    private String outcome;

    public Event(String serviceName, String type, String uniqueId, String fuelQty, String orderid, String stockid, String outcome) {
        this.serviceName = serviceName;
        Type = type;
        this.uniqueId = uniqueId;
        this.fuelQty = fuelQty;
        this.orderid = orderid;
        this.stockid = stockid;
        this.outcome = outcome;
    }


}
