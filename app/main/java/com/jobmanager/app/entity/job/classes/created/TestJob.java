package com.jobmanager.app.entity.job.classes.created;

import com.jobmanager.app.entity.job.Job;
import com.jobmanager.app.entity.job.schedule.time.basic.BasicTime;
import com.jobmanager.app.entity.job.schedule.scheduler.JobTimeScheduler;

import javax.persistence.Entity;
import java.time.ZonedDateTime;

@Entity
public class TestJob extends Job {

    public TestJob() {
        super(() -> {
            System.err.println("Hello world!");
            ZonedDateTime c = ZonedDateTime.now();
            ZonedDateTime n = c.plusSeconds(5);
            while (c.isBefore(n)) {
                c = ZonedDateTime.now();
            }
        }, new JobTimeScheduler(false, BasicTime.buildBasicTime(10, 0, 0, 0)));
    }
}
