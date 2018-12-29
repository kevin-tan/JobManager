package com.jobmanager.app.job.schedule;

import lombok.Data;

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

    public void calculateNextExecution(ZonedDateTime current){
        nextExecutionTime = schedule.getNextExecution(current);
    }
}
