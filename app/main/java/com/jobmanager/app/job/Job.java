package com.jobmanager.app.job;

import com.jobmanager.app.job.status.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Kevin Tan 2018-12-15
 */

@Entity
public abstract class Job extends Thread {

    @Id
    private Long id;
    @Column(name = "JOB_STATUS")
    private Status jobStatus;

    public Job(){
        jobStatus = Status.NOT_SCHEDULED;
    }

    @Override
    public synchronized void start(){

    }

    public abstract Runnable work();

}
