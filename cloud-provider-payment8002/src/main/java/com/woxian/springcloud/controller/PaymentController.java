package com.woxian.springcloud.controller;

import com.woxian.springcloud.entities.CommonResult;
import com.woxian.springcloud.entities.Payment;
import com.woxian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private Integer port;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);

        if (result>0){
            return new CommonResult(200,"success port:"+port,null);
        }
        return new CommonResult(400,"failed",null);
    }

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable Long id){
        Payment result=paymentService.getPaymentById(id);
        //log.info();
        System.out.println("ok");
        if (result!=null){
            return new CommonResult(200,"successs port:"+port,result);
        }
        return null;
    }

}
