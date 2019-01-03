package com.jobmanager.app.api.controller;

import com.jobmanager.app.api.service.JobService;
import com.jobmanager.app.entity.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Kevin Tan 2019-01-03
 */

@Controller("/dashboard")
public class JobController {

    protected final JobService jobService;

    @Autowired
    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/getAllJobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
}
