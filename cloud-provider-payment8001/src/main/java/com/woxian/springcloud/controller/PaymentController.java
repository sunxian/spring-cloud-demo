package com.woxian.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.woxian.springcloud.entities.CommonResult;
import com.woxian.springcloud.entities.Payment;
import com.woxian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private Integer port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);

        if (result>0){
            return new CommonResult(200,"success port:"+port,null);
        }
        return new CommonResult(400,"failed",null);
    }

    @GetMapping("/payment/get/{id}")
    //服务熔断
    @HystrixCommand(fallbackMethod = "getPaymentHystrixTimeOutDefault",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public CommonResult getPayment(@PathVariable Long id){
        if (id<0){
            throw  new RuntimeException("id<0");
        }
        Payment result=paymentService.getPaymentById(id);
        //log.info();
        System.out.println("ok");
        if (result!=null){
            return new CommonResult(200,"successs port"+port,result);
        }
        return null;
    }

    @GetMapping("/payment/get/timeout/{id}")
    public CommonResult getPaymentTimeOut(@PathVariable Long id){
       // Payment result=paymentService.getPaymentById(id);
        log.info("coming in ");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(400,"failed"+port,null);
    }

    @GetMapping("/payment/hystrix/get/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentHystrixTimeOutDefault",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public CommonResult getPaymentHystrixTimeOut(@PathVariable Long id){
        // Payment result=paymentService.getPaymentById(id);
        log.info("hystrix coming in ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(400,"failed"+port,null);
    }

    public CommonResult getPaymentHystrixTimeOutDefault(@PathVariable Long id){


        return new CommonResult(200,"plz wait",null);
    }
    @GetMapping(value = "/main/payment/discovery")
    public Object discovery(){

       List<String> services= discoveryClient.getServices();
        for (int i = 0; i < services.size(); i++) {
            log.info("******* element {}",i);
        }
List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance in :
                instances) {
            log.info(in.getServiceId()+"****"+"\t"+in.getHost()+"\t"+in.getPort()+"\t"+in.getUri());
        }
        return this.discoveryClient;
    }

}
