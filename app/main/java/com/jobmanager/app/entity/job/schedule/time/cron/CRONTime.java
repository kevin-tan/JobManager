package com.jobmanager.app.entity.job.schedule.time.cron;

import com.jobmanager.app.entity.job.schedule.time.JobTime;
import lombok.Data;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAmount;

/**
 * Class to hold the CRONTime structure
 */

@Data
public class CRONTime implements JobTime {

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
     * Create CRONTime with specified minute, hour, dayOfMoth, month and dayOfWeek
     *
     * @param minute     [0 - 59] long value & '*', ',' , '-'
     * @param hour       [0 - 23] long value & '*', ',' , '-'
     * @param dayOfMonth [1 - 31] long value & '*', ',' , '-'
     * @param month      [1 - 12] long value & '*', ',' , '-'
     * @param dayOfWeek  [0 - 6] long value & '*', ',' , '-'
     */
    // TODO : CRONTime values should be a string which allows '*', '-', ',' and numbers
    CRONTime(String minute, String hour, String dayOfMonth, String month, String dayOfWeek) {
        this.minute = validateCRONExpression(minute) ? minute : WILDCARD;
        this.hour = validateCRONExpression(hour) ? hour : WILDCARD;
        this.dayOfMonth = validateCRONExpression(dayOfMonth) ? dayOfMonth : WILDCARD;
        this.month = validateCRONExpression(month) ? month : WILDCARD;
        this.dayOfWeek = validateCRONExpression(dayOfWeek) ? dayOfWeek : WILDCARD;

        // TODO: initialize the adjusted com corresponding to the CRONTime expression
        this.executionTimeAdjustment = null;
    }

    /**
     * Create CRONTime with specified minute, hour, dayOfMoth, month and dayOfWeek, executionTimeAdjustment
     *
     * @param minute                  [0 - 59] long value & '*', ',' , '-'
     * @param hour                    [0 - 23] long value & '*', ',' , '-'
     * @param dayOfMonth              [1 - 31] long value & '*', ',' , '-'
     * @param month                   [1 - 12] long value & '*', ',' , '-'
     * @param dayOfWeek               [0 - 6] long value & '*', ',' , '-'
     * @param executionTimeAdjustment {@link TemporalAmount} for adjusting the next execution com
     */
    CRONTime(String minute, String hour, String dayOfMonth, String month, String dayOfWeek, TemporalAmount executionTimeAdjustment) {
        this.minute = minute;
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.executionTimeAdjustment = executionTimeAdjustment;
    }

    // TODO: CRONTime expression validator
    private boolean validateCRONExpression(String expr) {
        return false;
    }

    // TODO: CRONTime time update
    @Override
    public ZonedDateTime getNextExecution(ZonedDateTime current) {
        return current;
    }

    /**
     * To allow the building of a CRONBuilder minutely-schedule
     */
    public static CRONTime buildMinutelyCronSchedule() {
        return new CRONTime(WILDCARD, WILDCARD, WILDCARD, WILDCARD, WILDCARD, Duration.ofMinutes(1));
    }

    /**
     * To allow the building of a CRONBuilder hourly-schedule
     */
    public static CRONTime buildHourlyCronSchedule() {
        return new CRONTime("0", WILDCARD, WILDCARD, WILDCARD, WILDCARD, Duration.ofHours(1));
    }

    /**
     * To allow the building of a CRONBuilder daily-schedule (once a day, at midnight)
     */
    public static CRONTime buildDailyCronSchedule() {
        TemporalAmount amount = null;
        return new CRONTime("0", "0", WILDCARD, WILDCARD, WILDCARD, amount);
    }

    /**
     * To allow the building of a CRONBuilder weekly-schedule (once a week at midnight on Sunday morning)
     */
    public static CRONTime buildWeeklyCronSchedule() {
        TemporalAmount amount = null;
        return new CRONTime("0", "0", WILDCARD, WILDCARD, "0", amount);
    }

    /**
     * To allow the building of a CRONBuilder monthly-schedule (once a month at midnight on first day of month)
     */
    public static CRONTime buildMonthlyCronSchedule() {
        TemporalAmount amount = null;
        return new CRONTime("0", "0", "1", WILDCARD, WILDCARD, amount);
    }

    /**
     * To allow the building of a CRONBuilder annually(yearly)-schedule (once a year at midnight on 1st of January)
     */
    public static CRONTime buildYearlyCronSchedule() {
        TemporalAmount amount = null;
        return new CRONTime("0", "0", "1", "1", WILDCARD, amount);
    }

}
