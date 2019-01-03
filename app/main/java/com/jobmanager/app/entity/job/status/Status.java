package com.jobmanager.app.entity.job.status;

/**
 * Status enum class that represents the current job status.
 * Author: Kevin Tan
 * */
public enum Status {
    /**
     * Status: SCHEDULED
     * Def: Job is currently scheduled to run. This represents the state of the job when it is about to start running.
     * */
    SCHEDULED("SCHEDULED"),
    /**
     * Status: SCHEDULED
     * Def: Job is currently not scheduled to run.
     * */
    NOT_SCHEDULED("NOT SCHEDULED"),
    /**
     * Status: RUNNING
     * Def: Job is currently running.
     * */
    RUNNING("RUNNING"),
    /**
     * Status: FINISHED
     * Def: Job is finished running.
     * */
    FINISHED("FINISHED");

    private final String code;

    Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
