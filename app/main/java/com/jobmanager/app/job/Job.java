package com.jobmanager.app.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobmanager.app.job.schedule.scheduler.JobTimeScheduler;
import com.jobmanager.app.job.status.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.ZonedDateTime;

@Data
@Entity
public abstract class Job extends Thread {
    /* Id of the job to be used to save into the database */
    @Id
    private Long job_id;

    /* The current status of the job */
    @Column(name = "JOB_STATUS")
    private Status jobStatus;

    /* CRONBuilder schedule for the job to run */
    @Transient
    @JsonIgnore
    private JobTimeScheduler schedule;

    /**
     * Creating a job with no {@link #target} or {@link #schedule}
     * {@link #jobStatus} is set to {@code Status.NOT_SCHEDULED}
     *
     * @return {@link Job} Returns an empty Job instance
     */
    public Job() {
        jobStatus = Status.NOT_SCHEDULED;
    }

    /**
     * Creating fully initialize job with a CRON schedule.
     *
     * @param work     The work that the job will perform at a scheduled com
     * @param schedule The CRONBuilder schedule for the job. It can be a fixed
     *                 schedule or a one com run
     * @return {@link Job} Returns fully initialized Job instance
     * @see #run()
     */
    public Job(Runnable work, JobTimeScheduler schedule) {
        super(work);
        this.schedule = schedule;
    }

    /**
     * Overridden run method to set the status of current job.
     *
     * @see #run()
     */
    @Override
    public void run() {
        do {
            jobStatus = Status.SCHEDULED;
            ZonedDateTime now = ZonedDateTime.now();
            while(now.isBefore(schedule.getNextExecutionTime())){ now = ZonedDateTime.now(); }
            jobStatus = Status.RUNNING;
            schedule.calculateNextExecution(now);
            super.run();
        } while (!schedule.isRunOnce());
        jobStatus = Status.FINISHED;
    }

}
