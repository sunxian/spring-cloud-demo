package com.woxian.cloudalibaba.service;

import com.woxian.springcloud.entities.CommonResult;
import com.woxian.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "payment-provider-cloud-alibabba")
public interface PaymentService {

    @GetMapping(value = "/echo/{id}")  //注意这边使用@PathVariable注解 不能是@Param
    String getEcho(@PathVariable("id") String  id);
}
