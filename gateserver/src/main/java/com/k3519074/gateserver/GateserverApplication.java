package com.k3519074.gateserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateserverApplication.class, args);
    }

}
