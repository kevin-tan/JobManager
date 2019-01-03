package com.jobmanager.app.manager.creator;

import com.jobmanager.app.entity.job.Job;
import com.jobmanager.app.entity.job.classes.JobFactory;
import com.jobmanager.app.entity.job.classes.created.TestJob;
import com.jobmanager.app.manager.classes.Jobs;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JobCreator {

    /**
     * Map that holds the class name and its corresponding instance creation method
     */
    private final Map<Jobs, JobFactory> factories = new HashMap<>();

    /**
     * Initialize all factories here.
     */
    public JobCreator() {
        factories.put(Jobs.TEST_JOB, TestJob::new);
    }

    /**
     * Uses the className to retrieve the corresponding instance factory, creates and returns the job.
     *
     * @param className The String name of class used to retrieve its factory from hash table
     * @return Job
     */
    public Job getInstanceForJob(Jobs className) {
        return factories.get(className).createInstance();
    }

}
