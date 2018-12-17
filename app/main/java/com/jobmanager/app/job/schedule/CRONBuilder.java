package com.jobmanager.app.job.schedule;

public class CRONBuilder {

    /**
     * CRON private static inner-class for holding the CRON structure
     */
    private static class CRON {
        Long minute;
        Long hour;
        Long dayOfMonth;
        Long month;
        Long dayOfWeek;

        /**
         * Create CRONBuilder with specified minute, hour, dayOfMoth, month and dayOfWeek
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

    /* WILDCARD(-1L) represents * as in Linux/Unix CRONBuilder */
    private final static Long WILDCARD = -1L;

    /**
     * CRONBuilder is a CRON builder. No instance of {@link CRONBuilder} should exist.
     */
    private CRONBuilder() {}

    /* To allow the building of a CRONBuilder hourly-schedule */
    public static CRON buildHourlyCronSchedule() {
        return new CRON(0L, WILDCARD, WILDCARD, WILDCARD, WILDCARD);
    }

    /* To allow the building of a CRONBuilder daily-schedule (once a day, at midnight) */
    public static CRON buildDailyCronSchedule() {
        return new CRON(0L, 0L, WILDCARD, WILDCARD, WILDCARD);
    }

    /* To allow the building of a CRONBuilder weekly-schedule (once a week at midnight on Sunday morning) */
    public static CRON buildWeeklyCronSchedule() {
        return new CRON(0L, 0L, WILDCARD, WILDCARD, 0L);
    }

    /* To allow the building of a CRONBuilder monthly-schedule (once a month at midnight on first day of month) */
    public static CRON buildMonthlyCronSchedule() {
        return new CRON(0L, 0L, 1L, WILDCARD, WILDCARD);
    }

    /* To allow the building of a CRONBuilder annually(yearly)-schedule (once a year at midnight on 1st of January) */
    public static CRON buildYearlyCronSchedule() {
        return new CRON(0L, 0L, 1L, 1L, WILDCARD);
    }

}
