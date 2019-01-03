package com.jobmanager.app.manager.updator;

import com.jobmanager.app.entity.dao.JobRepository;
import com.jobmanager.app.entity.job.Job;
import com.jobmanager.app.pattern.observer.Observer;
import com.jobmanager.app.pattern.observer.Subject;

public class JobUpdater implements Observer {

    private final JobRepository jobRepository;

    public JobUpdater(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public void update(Subject subject) {
        jobRepository.save((Job)subject); // Safe down-cast
    }
}
