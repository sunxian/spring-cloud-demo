package com.woxian.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {



    @Value("${version}")
    private String version;
    @GetMapping("/configinfo")
    public  String getConfigInfo(){
        return version;
    }

}
