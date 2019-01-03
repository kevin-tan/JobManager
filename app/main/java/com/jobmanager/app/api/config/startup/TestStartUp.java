package com.jobmanager.app.api.config.startup;

import com.jobmanager.app.job.classes.created.TestJob;
import com.jobmanager.app.manager.JobManager;

import javax.annotation.PostConstruct;

/**
 * Created by Kevin Tan 2019-01-03
 */
public class TestStartUp {

    private final JobManager jobManager;

    public TestStartUp(JobManager jobManager){
        this.jobManager = jobManager;
    }

    @PostConstruct
    public void run(){
        System.err.println("Startup...");
        jobManager.createAndAddNewJob(TestJob.class.getSimpleName());
        jobManager.runAllJobs();
    }

}
