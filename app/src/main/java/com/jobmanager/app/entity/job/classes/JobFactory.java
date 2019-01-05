package com.jobmanager.app.entity.job.classes;

import com.jobmanager.app.entity.job.Job;

@FunctionalInterface
public interface JobFactory <T extends Job>{

    /**
     * Method used for lambda expression for the definition of an instance's factory
     * @return Returns the Job created using the Factory
     */
    T createInstance();
}
