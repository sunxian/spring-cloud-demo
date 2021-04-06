package com.woxian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMian80 {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderMian80.class,args);
    }
}
