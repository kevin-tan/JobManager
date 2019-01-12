package com.jobmanager.app.entity.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobmanager.app.entity.job.schedule.scheduler.JobTimeScheduler;
import com.jobmanager.app.entity.job.status.Status;
import com.jobmanager.app.pattern.observer.Observer;
import com.jobmanager.app.pattern.observer.Subject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Inheritance
@EqualsAndHashCode(callSuper = true)
public abstract class Job extends Thread implements Subject {

    /* Id of the job to be used to save into the database */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long job_id;

    /* The current status of the job */
    @Column(name = "JOB_STATUS")
    @Enumerated(EnumType.STRING)
    private Status jobStatus;

    /* Name of the current job */
    @Column(name = "JOB_NAME")
    private String jobName;

    /* CRONBuilder schedule for the job to run */
    @Transient
    @JsonIgnore
    private JobTimeScheduler schedule;

    /* List of observers to be notified on state change of this job */
    @Transient
    @JsonIgnore
    private List<Observer> observers = new LinkedList<>();

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
     * Creating fully initialize job with a CRONTime schedule.
     *
     * @param work     The work that the job will perform at a scheduled com
     * @param schedule The CRONBuilder schedule for the job. It can be a fixed
     *                 schedule or a one com run
     * @return {@link Job} Returns fully initialized Job instance
     * @see #run()
     */
    public Job(Runnable work, JobTimeScheduler schedule, String jobName) {
        super(work);
        this.jobStatus = Status.SCHEDULED;
        this.schedule = schedule;
        this.jobName = jobName;
    }

    /**
     * Overridden run method to set the status of current job.
     *
     * @see #run()
     */
    @Override
    public void run() {
        do {
            ZonedDateTime now = ZonedDateTime.now();
            while (now.isBefore(schedule.getNextExecutionTime())) { now = ZonedDateTime.now(); }
            setJobStatus(Status.RUNNING);
            schedule.calculateNextExecution(now);
            super.run();
            setJobStatus(Status.SCHEDULED);
        } while (!schedule.isRunOnce() || !interrupted());
        setJobStatus(Status.FINISHED);
    }

    @Override
    public void interrupt() {
        super.interrupt();
        try {
            join();
            setJobStatus(Status.STOPPED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void setJobStatus(Status status) {
        this.jobStatus = status;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }
}
