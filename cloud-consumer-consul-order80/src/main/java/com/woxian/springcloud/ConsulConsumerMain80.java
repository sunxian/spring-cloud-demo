package com.woxian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerMain80.class,args);
    }
}
