package com.manisha.service;

import com.manisha.entity.Schedule;
import com.manisha.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {


    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule (Schedule schedule){
        return scheduleRepository.save(schedule);

    }
    
    public List<Schedule> getAllSchedules() {
        List<Schedule> schedule= (List<Schedule>) scheduleRepository.findAll();
        return schedule;
    }

    public Schedule findDetailsById(int id) {
        List <Schedule> list=scheduleRepository.findAll();
        Schedule schedule =new Schedule ();
        for(Schedule sch:list){
            if(sch.getOrderId() == id){
                schedule.setScheduleId(sch.getScheduleId());
                schedule.setOrderId(sch.getOrderId());
                schedule.setDate(sch.getDate());

            }
        }


        return schedule;
    }

}
