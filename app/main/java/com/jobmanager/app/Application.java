package com.jobmanager.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Kevin Tan 2018-12-15
 */

@ComponentScan("com.jobmanager.app")
@EntityScan("com.jobmanager.app.dao")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

