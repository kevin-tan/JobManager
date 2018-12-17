package com.jobmanager.app.manager;

import com.jobmanager.app.job.Job;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kevin Tan 2018-12-15
 */

@Component
public class JobManager {

    private final List<Job> jobPool = new LinkedList<>();

    public JobManager(){

    }
}
