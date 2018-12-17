package com.jobmanager.app.manager;

import com.jobmanager.app.job.Job;
import com.jobmanager.app.manager.creator.JobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kevin Tan 2018-12-15
 */

@Component
public class JobManager {

    private JobCreator jobCreator;
    private final List<Job> jobPool = new LinkedList<>();

    @Autowired
    public JobManager(JobCreator jobCreator) {
        this.jobCreator = jobCreator;
    }

    /**
     * Add new job to current {@link #jobPool}
     *
     * @param job Job to be added to the {@link JobManager}'s {@link #jobPool}
     */
    public void addJob(Job job) {
        jobPool.add(job);
    }

    /**
     * Create and add new job to current {@link #jobPool}
     *
     * @param className The String name of class to be created
     */
    public Job createAndAddNewJob(String className) {
        Job job = jobCreator.getInstanceForClassName(className);
        jobPool.add(job);
        return job;
    }

    /**
     * Create new job
     *
     * @param className The String name of class to be created
     */
    public Job createNewJob(String className) {
        return jobCreator.getInstanceForClassName(className);
    }

}
