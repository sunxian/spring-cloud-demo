package com.woxian.springcloud.controller;

import com.woxian.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SendMQController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMsg")
 public void sendMsg(){

        messageProvider.send();
 }



}
