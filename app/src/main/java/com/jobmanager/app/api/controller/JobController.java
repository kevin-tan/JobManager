package com.jobmanager.app.api.controller;

import com.jobmanager.app.api.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kevin Tan 2019-01-03
 */

@Controller
@RequestMapping("/dashboard")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getJobs")
    public ResponseEntity<?> getAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/getAllFactories")
    public ResponseEntity<?> getAllFactories() {
        return new ResponseEntity<>(jobService.getAllFactories(), HttpStatus.OK);
    }
}
