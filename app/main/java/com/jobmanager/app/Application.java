package com.jobmanager.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Kevin Tan 2018-12-15
 */

@ComponentScan(basePackages = {"com.jobmanager.app", "com.jobmanager.app.entity.dao"})
@EntityScan("com.jobmanager.app")
@EnableJpaRepositories
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

