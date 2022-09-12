package com.manisha.event;

import lombok.Data;

@Data
public class ScheduleEvent {
    private String serviceName;
    private String Type;
    private String uniqueId;
    private String fuelQty;
    private String orderid;
    private String stockid;
    private String outcome;
    private String Date;


}
