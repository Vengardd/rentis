package com.vengard.rentis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vengard.rentis.controller", "com.vengard.rentis.service"})
public class RentisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentisApplication.class, args);
    }
}
