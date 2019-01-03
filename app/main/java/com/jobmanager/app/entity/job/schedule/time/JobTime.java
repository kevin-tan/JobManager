package com.jobmanager.app.entity.job.schedule.time;

import java.time.ZonedDateTime;

/**
 * Created by Kevin Tan 2019-01-03
 */
public interface JobTime {
    ZonedDateTime getNextExecution(ZonedDateTime current);
}
