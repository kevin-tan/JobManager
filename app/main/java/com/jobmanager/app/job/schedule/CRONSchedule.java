package com.jobmanager.app.job.schedule;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;

import static com.jobmanager.app.job.schedule.CRON.WILDCARD;

/**
 * CRONSchedule is used to set the CRONBuilder schedule for a {@link com.jobmanager.app.job.Job} to run on
 */
@Data
public class CRONSchedule {
    /* Whether the job should only be ran once */
    private boolean runOnce;

    /* CRONBuilder schedule for the job to run */
    private CRON schedule;

    /* Whether the job is running or awaiting to run
       if true, running, else awaiting to run */
    private boolean running;

    /* The next date time that the job will execute (if run once is false) */
    private ZonedDateTime nextExecutionTime;

    /**
     * Create a CRONSchedule that will perform the job at a fixed rate, or once only
     *
     * @param runOnce if {@code true}, job will run once only,
     *                all custom CRONBuilder schedule will be ignore ({@link #schedule} is null)
     */
    public CRONSchedule(boolean runOnce, CRON schedule) {
        this.runOnce = runOnce;
        if (!runOnce) {
            this.schedule = schedule;
            calculateNextExecution(ZonedDateTime.now());
        }
        this.running = false;
    }


    // TODO: Need to adjust according current date to CRON for next execution
    public void calculateNextExecution(ZonedDateTime current){
        int year = current.getYear();

        if(schedule.getMinute() == WILDCARD || schedule.getHour() == WILDCARD){

        }else{
            if(schedule.getDayOfWeek() == WILDCARD){

            }
            if(schedule.getDayOfMonth() == WILDCARD){

            }
            if(schedule.getMonth() == WILDCARD){

            }
        }
        // 2018 - 12 - 29 - 6 - 9 - 53
        nextExecutionTime = current;
    }
}
