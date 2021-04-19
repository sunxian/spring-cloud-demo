package com.woxian.cloudalibaba.controller;

import com.woxian.cloudalibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentService paymentFeignService;

    @GetMapping("/consumer/echo/{id}")
    public String getEcho(@PathVariable String  id){
        return paymentFeignService.getEcho(id);
    }
}
