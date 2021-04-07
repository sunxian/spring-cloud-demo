package com.woxian.springcloud.service;

import com.woxian.springcloud.entities.CommonResult;
import com.woxian.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(200,"sorry,server is busy,plz retry later",null);
    }
}
