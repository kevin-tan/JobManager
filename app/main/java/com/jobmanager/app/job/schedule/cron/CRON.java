package com.jobmanager.app.job.schedule.cron;

import com.jobmanager.app.job.schedule.JobTime;
import lombok.Data;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAmount;

/**
 * Class to hold the CRON structure
 */

@Data
public class CRON implements JobTime {

    public final static String WILDCARD = "*";
    public final static String HYPHEN = "-";
    public final static String COMMA = ",";

    private String month;
    private String dayOfMonth;
    private String dayOfWeek;
    private String minute;
    private String hour;

    private TemporalAmount executionTimeAdjustment;

    /**
     * Create CRON with specified minute, hour, dayOfMoth, month and dayOfWeek
     *
     * @param minute     [0 - 59] long value & '*', ',' , '-'
     * @param hour       [0 - 23] long value & '*', ',' , '-'
     * @param dayOfMonth [1 - 31] long value & '*', ',' , '-'
     * @param month      [1 - 12] long value & '*', ',' , '-'
     * @param dayOfWeek  [0 - 6] long value & '*', ',' , '-'
     */
    // TODO : CRON values should be a string which allows '*', '-', ',' and numbers
    CRON(String minute, String hour, String dayOfMonth, String month, String dayOfWeek) {
        this.minute = validateCRONExpression(minute) ? minute : WILDCARD;
        this.hour = validateCRONExpression(hour) ? hour : WILDCARD;
        this.dayOfMonth = validateCRONExpression(dayOfMonth) ? dayOfMonth : WILDCARD;
        this.month = validateCRONExpression(month) ? month : WILDCARD;
        this.dayOfWeek = validateCRONExpression(dayOfWeek) ? dayOfWeek : WILDCARD;

        // TODO: initialize the adjusted com corresponding to the CRON expression
        this.executionTimeAdjustment = null;
    }

    /**
     * Create CRON with specified minute, hour, dayOfMoth, month and dayOfWeek, executionTimeAdjustment
     *
     * @param minute                  [0 - 59] long value & '*', ',' , '-'
     * @param hour                    [0 - 23] long value & '*', ',' , '-'
     * @param dayOfMonth              [1 - 31] long value & '*', ',' , '-'
     * @param month                   [1 - 12] long value & '*', ',' , '-'
     * @param dayOfWeek               [0 - 6] long value & '*', ',' , '-'
     * @param executionTimeAdjustment {@link TemporalAmount} for adjusting the next execution com
     */
    CRON(String minute, String hour, String dayOfMonth, String month, String dayOfWeek, TemporalAmount executionTimeAdjustment) {
        this.minute = minute;
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.executionTimeAdjustment = executionTimeAdjustment;
    }

    // TODO: CRON expression validator
    private boolean validateCRONExpression(String expr) {
        return false;
    }

    // TODO: CRON time update
    @Override
    public ZonedDateTime getNextExecution(ZonedDateTime current) {
        return current;
    }

    /**
     * To allow the building of a CRONBuilder minutely-schedule
     */
    public static CRON buildMinutelyCronSchedule() {
        return new CRON(WILDCARD, WILDCARD, WILDCARD, WILDCARD, WILDCARD, Duration.ofMinutes(1));
    }

    /**
     * To allow the building of a CRONBuilder hourly-schedule
     */
    public static CRON buildHourlyCronSchedule() {
        return new CRON("0", WILDCARD, WILDCARD, WILDCARD, WILDCARD, Duration.ofHours(1));
    }

    /**
     * To allow the building of a CRONBuilder daily-schedule (once a day, at midnight)
     */
    public static CRON buildDailyCronSchedule() {
        TemporalAmount amount = null;
        return new CRON("0", "0", WILDCARD, WILDCARD, WILDCARD, amount);
    }

    /**
     * To allow the building of a CRONBuilder weekly-schedule (once a week at midnight on Sunday morning)
     */
    public static CRON buildWeeklyCronSchedule() {
        TemporalAmount amount = null;
        return new CRON("0", "0", WILDCARD, WILDCARD, "0", amount);
    }

    /**
     * To allow the building of a CRONBuilder monthly-schedule (once a month at midnight on first day of month)
     */
    public static CRON buildMonthlyCronSchedule() {
        TemporalAmount amount = null;
        return new CRON("0", "0", "1", WILDCARD, WILDCARD, amount);
    }

    /**
     * To allow the building of a CRONBuilder annually(yearly)-schedule (once a year at midnight on 1st of January)
     */
    public static CRON buildYearlyCronSchedule() {
        TemporalAmount amount = null;
        return new CRON("0", "0", "1", "1", WILDCARD, amount);
    }

}
