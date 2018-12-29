package com.jobmanager.app.job.schedule;

import lombok.Data;

/**
 * Class to hold the CRON structure
 */

@Data
public class CRON {
    /**
     * WILDCARD(-1L) represents * as in Linux/Unix CRONBuilder
     */
    private final static int WILDCARD = -1;

    private int month;
    private int dayOfMonth;
    private int dayOfWeek;
    private int minute;
    private int hour;

    /**
     * Create CRON with specified minute, hour, dayOfMoth, month and dayOfWeek
     *
     * @param minute     [0 - 59] long value
     * @param hour       [0 - 23] long value
     * @param dayOfMonth [1 - 31] long value
     * @param month      [1 - 12] long value
     * @param dayOfWeek  [0 - 6] long value
     */
    CRON(int minute, int hour, int dayOfMonth, int month, int dayOfWeek) {
        this.minute = minute;
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * To allow the building of a CRONBuilder minutely-schedule
     */
    public static CRON buildMinutelyCronSchedule() {
        return new CRON(WILDCARD, WILDCARD, WILDCARD, WILDCARD, WILDCARD);
    }

    /**
     * To allow the building of a CRONBuilder hourly-schedule
     */
    public static CRON buildHourlyCronSchedule() {
        return new CRON(0, WILDCARD, WILDCARD, WILDCARD, WILDCARD);
    }

    /**
     * To allow the building of a CRONBuilder daily-schedule (once a day, at midnight)
     */
    public static CRON buildDailyCronSchedule() {
        return new CRON(0, 0, WILDCARD, WILDCARD, WILDCARD);
    }

    /**
     * To allow the building of a CRONBuilder weekly-schedule (once a week at midnight on Sunday morning)
     */
    public static CRON buildWeeklyCronSchedule() {
        return new CRON(0, 0, WILDCARD, WILDCARD, 0);
    }

    /**
     * To allow the building of a CRONBuilder monthly-schedule (once a month at midnight on first day of month)
     */
    public static CRON buildMonthlyCronSchedule() {
        return new CRON(0, 0, 1, WILDCARD, WILDCARD);
    }

    /**
     * To allow the building of a CRONBuilder annually(yearly)-schedule (once a year at midnight on 1st of January)
     */
    public static CRON buildYearlyCronSchedule() {
        return new CRON(0, 0, 1, 1, WILDCARD);
    }

}
