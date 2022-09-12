import { Injectable } from '@nestjs/common';
import { v1 as uuid } from 'uuid'
import { Schedule } from './schedule.model';
import { ScheduleSearchDto } from './scheduleSearch.dto';

@Injectable()
export class ScheduleService {

    private schedule  

    createSchedule(orderId : string, date : Date){

        const schedule = {
            scheduleId: uuid(),
            orderId,
            date
        }
         
        this.schedule.push(schedule)
        return schedule;

    }

    getAllSchedules(){
        return this.schedule;
    }


    findDetailsById(scheduleId : string) : Schedule{
        const schedule = this.getAllSchedules();
        return schedule.find(schedule => schedule.id == scheduleId)
    }


    scheduleSearch(scheduleSearchDto : ScheduleSearchDto){
        console.log(scheduleSearchDto);
        const { scheduleId } = scheduleSearchDto;
        let schedule = this.getAllSchedules();
        if(scheduleId){
            schedule = schedule.filter(schedule => schedule.scheduleId === scheduleId)
        }
 
    }





}
