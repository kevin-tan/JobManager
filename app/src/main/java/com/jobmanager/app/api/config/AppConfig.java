package com.jobmanager.app.api.config;

import com.jobmanager.app.api.config.startup.TestStartUp;
import com.jobmanager.app.manager.JobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kevin Tan 2019-01-03
 */

@Configuration
public class AppConfig {

    @Bean
    public TestStartUp testStartUp(@Autowired JobManager jobManager){
        return new TestStartUp(jobManager);
    }

}
