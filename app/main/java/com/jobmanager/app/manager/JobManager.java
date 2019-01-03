package com.jobmanager.app.manager;

import com.jobmanager.app.entity.dao.JobRepository;
import com.jobmanager.app.entity.job.Job;
import com.jobmanager.app.manager.classes.Jobs;
import com.jobmanager.app.manager.creator.JobCreator;
import com.jobmanager.app.manager.updator.JobUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JobManager {

    /* Component used to retrieve the factory to create a job */
    private JobCreator jobCreator;

    /* List of jobs currently being managed by the JobManager */
    private final Map<Long, Job> jobPool = new HashMap<>();

    /* Spring CRUD Repository to save our Job entity to the SQL database */
    private final JobRepository jobRepository;

    @Autowired
    public JobManager(JobCreator jobCreator, JobRepository jobRepository) {
        this.jobCreator = jobCreator;
        this.jobRepository = jobRepository;
    }

    /**
     * Create and add new job to current {@link #jobPool}
     *
     * @param jobName The String name of class to be created
     * @return {@link Job} Returns the job created
     */
    public Job createAndAddNewJob(Jobs jobName) {
        Job job = jobRepository.save(jobCreator.getInstanceForJob(jobName));
        job.attach(new JobUpdater(jobRepository));
        jobPool.put(job.getJob_id(), job);
        return job;
    }

    public void runAllJobs() {
        for(Long key: jobPool.keySet()){
            jobPool.get(key).run();
        }
    }
}
