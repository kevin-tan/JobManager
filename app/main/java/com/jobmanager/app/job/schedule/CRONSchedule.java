package com.jobmanager.app.job.schedule;

import lombok.Data;

/**
 * CRONSchedule is used to set the CRONBuilder schedule for a {@link com.jobmanager.app.job.Job} to run on
 */
@Data
public class CRONSchedule {
    /* Whether the job should only be ran once */
    private boolean runOnce;

    /* CRONBuilder schedule for the job to run */
    private CRONBuilder schedule;

    /* Whether the job is running or awaiting to run
       if true, running, else awaiting to run */
    private boolean running;

    /**
     * Create a CRONSchedule that will perform the job at a fixed rate, or once only
     *
     * @param runOnce if {@code true}, job will run once only,
     *                all custom CRONBuilder schedule will be ignore ({@link #schedule} is null)
     */
    public CRONSchedule(boolean runOnce, CRONBuilder schedule) {
        this.runOnce = runOnce;
        if (!runOnce) this.schedule = schedule;
        this.running = false;
    }
}
