package com.jobmanager.app.api.service;

import com.jobmanager.app.entity.job.Job;
import com.jobmanager.app.manager.JobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kevin Tan 2019-01-03
 */

@Service
public class JobService {

    private final JobManager jobManager;

    @Autowired
    public JobService(JobManager jobManager){
        this.jobManager = jobManager;
    }

    public List<Job> getAllJobs(){
        return new LinkedList<>(jobManager.getJobPool().values());
    }

}
