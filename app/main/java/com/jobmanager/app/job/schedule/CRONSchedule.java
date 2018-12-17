package com.jobmanager.app.job.schedule;

import lombok.Data;

/**
 * CRONSchedule is used to set the CRON schedule for a {@link com.jobmanager.app.job.Job} to run on
 */
@Data
public class CRONSchedule {

    /**
     * Private static inner-class to hold the CRON data structure
     */
    private static class CRON {
        Long minute;
        Long hour;
        Long dayOfMonth;
        Long month;
        Long dayOfWeek;

        /**
         * Create CRON with specified minute, hour, dayOfMoth, month and dayOfWeek
         *
         * @param minute     [0 - 59] long value
         * @param hour       [0 - 23] long value
         * @param dayOfMonth [1 - 31] long value
         * @param month      [1 - 12] long value
         * @param dayOfWeek  [0 - 6] long value
         */
        CRON(Long minute, Long hour, Long dayOfMonth, Long month, Long dayOfWeek) {
            this.minute = minute;
            this.hour = hour;
            this.dayOfMonth = dayOfMonth;
            this.month = month;
            this.dayOfWeek = dayOfWeek;
        }
    }

    /**
     * To allow the building of a CRON schedule
     */
    public static CRON buildCronSchedule(Long minute, Long hour, Long dayOfMonth, Long month, Long dayOfWeek) {
        return new CRON(minute, hour, dayOfMonth, month, dayOfWeek);
    }

    /* Whether the job should only be ran once */
    private boolean runOnce;

    /* CRON schedule for the job to run */
    private CRON schedule;

    /* Whether the job is running or awaiting to run
       if true, running, else awaiting to run */
    private boolean running;

    /**
     * Create a CRONSchedule that will perform the job at a fixed rate, or once only
     *
     * @param runOnce if {@code true}, job will run once only,
     *                all custom CRON schedule will be ignore ({@link #schedule} is null)
     */
    public CRONSchedule(boolean runOnce, CRON schedule) {
        this.runOnce = runOnce;
        if (!runOnce) this.schedule = schedule;
        this.running = false;
    }
}
