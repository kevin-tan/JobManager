package com.jobmanager.app.job.schedule;

import lombok.Data;

/**
 * CRONSchedule is a reusable class to set the CRON schedule for a {@link com.jobmanager.app.job.Job} to run on.
 */
@Data
public class CRONSchedule {

    /* Whether the job should only be ran once */
    private boolean runOnce;

    /**
     * Create a CRONSchedule that will perform the job at a fixed rate, or once only.
     *
     * @param runOnce if {@code true}, job will run once only,
     *                all custom CRON schedule will be ignore.
     */
    public CRONSchedule(boolean runOnce) {
        this.runOnce = runOnce;
    }

}
