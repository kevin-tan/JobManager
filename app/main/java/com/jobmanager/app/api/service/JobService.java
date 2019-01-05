package com.jobmanager.app.api.service;

import com.jobmanager.app.entity.job.parser.JobParser;
import com.jobmanager.app.manager.JobManager;
import com.jobmanager.app.manager.classes.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    public List<?> getAllJobs(){
        List jobs = new LinkedList<>();
        for(Long key: jobManager.getJobPool().keySet()){
            jobs.add(JobParser.getParsedJob(jobManager.getJobPool().get(key)));
        }
        return jobs;
    }

    public Set<Jobs> getAllFactories(){
        return jobManager.getAllFactories();
    }
}
