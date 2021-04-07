package com.woxian.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.woxian.springcloud.entities.CommonResult;
import com.woxian.springcloud.entities.Payment;
import com.woxian.springcloud.service.PaymentFeignService;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "get_Gloal_FallBack")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/feignconsumer/payment/get/{id}")
    @HystrixCommand
    public CommonResult<Payment> getPayment(@PathVariable Long id){

        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/feignconsumer/test")
    @HystrixCommand
    public CommonResult<Payment> consumerTest(){
         int age=1/0;
         // 不加@HystrixCommand 发生1/0异常 不触发定义在接口的降级
        return new CommonResult<>(200,"ok",null);
    }

    //fallback方法的参数和返回类型需要与原方法一致
    public CommonResult<Payment> get_Gloal_FallBack(){

        return new CommonResult<>(200,"sorry,server is busy,plz retry later",null);
    }
}

