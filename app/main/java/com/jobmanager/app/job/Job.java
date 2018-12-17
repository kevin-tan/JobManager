package com.jobmanager.app.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobmanager.app.job.schedule.CRONSchedule;
import com.jobmanager.app.job.status.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Entity
public abstract class Job extends Thread {
    /* Id of the job to be used to save into the database */
    @Id
    private Long id;

    /* The current status of the job */
    @Column(name = "JOB_STATUS")
    private Status jobStatus;

    /* CRON schedule for the job to run */
    @Transient
    @JsonIgnore
    private CRONSchedule schedule;

    /**
     * Creating a job with no CRON schedule.
     *
     * @param work The work that the job will perform at a scheduled time.
     *
     * @see #run()
     */
    public Job(Runnable work) {
        super(work);
        jobStatus = Status.NOT_SCHEDULED;
    }

    /**
     * Creating fully initialize job.
     *
     * @param work     The work that the job will perform at a scheduled time.
     * @param schedule The CRON schedule for the job. It can be a fixed
     *                 schedule or a one time run.
     *
     * @see #run()
     */
    public Job(Runnable work, CRONSchedule schedule) {
        super(work);
        this.schedule = schedule;
    }

    /**
     * Overridden run method to set the status of current job.
     *
     * @see #run()
     */
    @Override
    public void run(){
        this.jobStatus = Status.RUNNING;
        super.run();
        this.jobStatus = Status.FINISHED;
    }

}