package com.jobmanager.app.job.classes.created;

import com.jobmanager.app.job.Job;
import com.jobmanager.app.job.schedule.CRON;
import com.jobmanager.app.job.schedule.CRONSchedule;
import org.springframework.stereotype.Component;

public class TestJob extends Job {

    public TestJob() {
        super(() -> System.err.println("Hello world!"), new CRONSchedule(false, CRON.buildMinutelyCronSchedule()));
    }
}
