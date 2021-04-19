package com.woxian.cloudalibaba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient

public class PaymentProviderMain9001 {



    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderMain9001.class,args);
    }

    @RestController
    @RefreshScope
    class EchoController {

        @Value("${server.port}")
        private String port;

        @Value("${version}")
        private String version;
        @Resource
        private  RestTemplate restTemplate;

        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string+" port "+port;
        }
        @RequestMapping(value = "/version", method = RequestMethod.GET)
        public String version() {
            return "Hello ,version " + version+" port "+port;
        }

    }
}
