package com.jobmanager.app.manager.creator;

import com.jobmanager.app.job.Job;
import com.jobmanager.app.job.classes.JobFactory;
import com.jobmanager.app.job.classes.created.TestJob;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JobCreator {

    /**
     * Map that holds the class name and its corresponding instance creation method
     */
    private final Map<String, JobFactory> factories = new HashMap<>();

    public JobCreator() {
        factories.put(TestJob.class.getSimpleName(), TestJob::new);
    }

    public Job getInstanceForClassName(String className) {
        return factories.get(className).createInstance();
    }

}
