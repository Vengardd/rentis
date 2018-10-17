package com.vengard.rentis.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.vengard.rentis.application", "com.vengard.rentis.controller",
        "com.vengard.rentis.repository", "com.vengard.rentis.service",
        "com.vengard.rentis.security", "com.vengard.rentis.model"})
@EnableJpaRepositories(basePackages = "com.vengard.rentis.repository")
@EntityScan("com.vengard.rentis.model")
public class RentisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentisApplication.class, args);
    }
}
