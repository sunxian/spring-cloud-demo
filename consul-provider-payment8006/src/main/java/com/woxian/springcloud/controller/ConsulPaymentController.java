package com.woxian.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ConsulPaymentController {

        @Value("${server.port}")
        private Integer port;

        @GetMapping("/payment8006")
        public String getPayment(){

            return "consul-payment"+port+ " "+ IdUtil.simpleUUID();
        }


}
