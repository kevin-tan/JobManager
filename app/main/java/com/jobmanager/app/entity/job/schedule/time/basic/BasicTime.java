package com.jobmanager.app.entity.job.schedule.time.basic;

import com.jobmanager.app.entity.job.schedule.time.JobTime;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by Kevin Tan 2019-01-03
 */

@Data
public class BasicTime implements JobTime {

    private int seconds;
    private int minutes;
    private int hours;
    private int days;

    /**
     * Creates a BasicTime for the jobs to run on (i.e. every 1 hour and 30 minutes from now).
     *
     * @param seconds long value representing seconds
     * @param minutes long value representing minutes
     * @param hours   long value representing hours
     * @param days    long value representing days
     */
    private BasicTime(int seconds, int minutes, int hours, int days) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.days = days;
    }

    public static BasicTime buildBasicTime(int seconds, int minutes, int hours, int days) {
        return new BasicTime(seconds, minutes, hours, days);
    }

    @Override
    public ZonedDateTime getNextExecution(ZonedDateTime current) {
        return current.plusSeconds(seconds).plusMinutes(minutes).plusHours(hours).plusDays(days);
    }
}
