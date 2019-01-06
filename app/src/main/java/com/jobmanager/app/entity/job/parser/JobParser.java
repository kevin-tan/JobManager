package com.jobmanager.app.entity.job.parser;

import com.jobmanager.app.entity.job.Job;
import com.jobmanager.app.entity.job.status.Status;
import lombok.Data;

/**
 * Created by Kevin Tan 2019-01-03
 */

public final class JobParser {

    @Data
    static class JobDTO{
        private Long id;
        private Status status;
        private String jobName;

        JobDTO(Long id, Status status, String jobName){
            this.id = id;
            this.status =status;
            this.jobName = jobName;
        }
    }

    public static JobDTO getParsedJob(Job job){
        return new JobDTO(job.getJob_id(), job.getJobStatus(), job.getJobName());
    }

}
