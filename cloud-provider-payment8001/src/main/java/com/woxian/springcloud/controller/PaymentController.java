package com.woxian.springcloud.controller;


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

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable Long id){
        Payment result=paymentService.getPaymentById(id);
        //log.info();
        System.out.println("ok");
        if (result!=null){
            return new CommonResult(200,"successs port"+port,result);
        }
        return null;
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
