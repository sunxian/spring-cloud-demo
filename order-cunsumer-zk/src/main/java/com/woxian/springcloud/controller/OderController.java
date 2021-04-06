package com.woxian.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OderController {
    @Resource
    private RestTemplate restTemplate;
    public static final String INVOKE_URL="http://cloud-provider-payment8004";

    @RequestMapping("/consumer/pay")
    public String  Test(){
        String result= restTemplate.getForObject(INVOKE_URL+"/payment8004",String.class);
        return result;
    }
}
