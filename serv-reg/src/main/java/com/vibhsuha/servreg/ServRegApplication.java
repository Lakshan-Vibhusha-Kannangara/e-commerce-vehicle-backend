package com.vibhsuha.servreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServRegApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServRegApplication.class, args);
    }

}
