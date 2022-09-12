import { Controller, Get, Param, Post, Query, Body } from '@nestjs/common';
import { ScheduleService } from './schedule.service';
import { ScheduleSearchDto } from './scheduleSearch.dto'; { }




@Controller('schedule')
export class ScheduleController {

    constructor(private scheduleService: ScheduleService) {
    }

    @Get()
    getAllSchedules(@Query() param: ScheduleSearchDto) {

        if (Object.keys(param).length) {
            console.log('filter')
            return this.scheduleService.scheduleSearch(param);
        } else {
            console.log('No filter')
            return this.scheduleService.getAllSchedules();
        }


    }


    @Post()
    createSchedule(@Body('orderId') orderId: string, @Body('date ') date: Date,) {

        return this.scheduleService.createSchedule(orderId,date);
    }



    @Get('/:id')
    findDetailsById(@Param('scheduleId') scheduleId: string) {
        return this.scheduleService.findDetailsById(scheduleId);
    }

}
