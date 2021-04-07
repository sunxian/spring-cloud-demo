package com.woxian.springcloud.service;

import com.woxian.springcloud.entities.CommonResult;
import com.woxian.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 对feign接口添加统一的服务降级类
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")  //注意这边使用@PathVariable注解 不能是@Param
     CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
