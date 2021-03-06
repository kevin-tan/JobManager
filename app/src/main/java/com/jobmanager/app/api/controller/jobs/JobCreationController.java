package com.jobmanager.app.api.controller.jobs;

import com.jobmanager.app.api.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Kevin Tan 2018-12-15
 */

@Controller
public class JobCreationController{

    private final JobService jobService;

    @Autowired
    public JobCreationController(JobService jobService) {
        this.jobService = jobService;
    }
}
