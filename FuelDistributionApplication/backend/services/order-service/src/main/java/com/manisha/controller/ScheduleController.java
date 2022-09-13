package com.manisha.controller;

import com.manisha.entity.Schedule;
import com.manisha.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    
    @GetMapping("/allSchedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/all")
    public Schedule getAllSchedules(@RequestParam int id){
        return scheduleService.findDetailsById(id);

    }
    
     

}
