package com.qianxia.experiment.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;


/**
 * @author qianxia
 * @date 2021/11/16  14:05
 */
public class MailController {

    @Resource
    private JavaMailSender javaMailSender;

    @GetMapping("/test")
    public void demo() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Maleon@startdt.com");
        message.setTo("867724561@qq.com");
        message.setSubject("邮件发送测试");
        message.setText("你好，世界");
        javaMailSender.send(message);
    }
}
