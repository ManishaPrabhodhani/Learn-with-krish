import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ScheduleServiceModule } from './schedule-service/schedule-service.module';
import { ScheduleController } from './schedule/schedule.controller';
import { ScheduleService } from './schedule/schedule.service';

@Module({
  imports: [ScheduleServiceModule],
  controllers: [AppController, ScheduleController],
  providers: [AppService, ScheduleService],
})
export class AppModule {}
