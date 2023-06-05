package ua.ivanov.ClimateControlService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import ua.ivanov.ClimateControlService.dto.ProfileRecordSchedulerDTO;
import ua.ivanov.ClimateControlService.models.ClimateProfileRecord;
import ua.ivanov.ClimateControlService.utilities.ClimateProfileRecordSendTask;
import ua.ivanov.ClimateControlService.utilities.CronExpressionConverter;

@Service
public class TaskSchedulerService {
    private final TaskScheduler taskScheduler;
    private List<ScheduledFuture<?>> scheduledTasks;

    @Autowired
    public TaskSchedulerService(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
        scheduledTasks = new ArrayList<>();
    }
    public void scheduleProfileSending(List<ClimateProfileRecord> recordList,String ip){
        for (ClimateProfileRecord climateProfileRecord : recordList) {
            ClimateProfileRecordSendTask task = new ClimateProfileRecordSendTask(
                new ProfileRecordSchedulerDTO(climateProfileRecord),ip);
            String cronExpression= CronExpressionConverter.convertToCronExpression(climateProfileRecord.startTime);
            scheduleTask(task,cronExpression);
        }
    }
    public void scheduleTask(ClimateProfileRecordSendTask Task,String cronExpression) {
        ScheduledFuture<?> scheduledTask = 
            taskScheduler.schedule(Task, new CronTrigger(cronExpression));
        scheduledTasks.add(scheduledTask);
    }

    public void cancelAllScheduledTasks() {
        for (ScheduledFuture<?> task : scheduledTasks) {
            task.cancel(true);
        }
        scheduledTasks.clear();
    }
}
