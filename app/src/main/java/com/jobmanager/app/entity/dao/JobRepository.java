package com.jobmanager.app.entity.dao;

import com.jobmanager.app.entity.job.Job;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kevin Tan 2019-01-03
 */

public interface JobRepository extends CrudRepository<Job, Long> {

}
