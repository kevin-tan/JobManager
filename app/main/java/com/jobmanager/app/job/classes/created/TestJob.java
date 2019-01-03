package com.jobmanager.app.job.classes.created;

import com.jobmanager.app.job.Job;
import com.jobmanager.app.job.schedule.basic.BasicTime;
import com.jobmanager.app.job.schedule.cron.CRON;
import com.jobmanager.app.job.schedule.scheduler.JobTimeScheduler;

public class TestJob extends Job {

    public TestJob() {
        super(() -> System.err.println("Hello world!"), new JobTimeScheduler(false, BasicTime.buildBasicTime(10,0,0,0)));
    }
}
