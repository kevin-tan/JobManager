package com.jobmanager.app.job.classes;

import com.jobmanager.app.job.Job;

@FunctionalInterface
public interface JobFactory <T extends Job>{
    T createInstance();
}
