package com.woxian.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.woxian.springcloud.entities.CommonResult;
import com.woxian.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer port;


    @GetMapping("/payment8004")
    public String getPayment(){


        return "payment"+port+ " "+IdUtil.simpleUUID();
    }
}
