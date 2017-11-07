package com.darcytech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    MailProperties mailProperties;

    public void sendMail(String target, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.getUsername());//这里的发送者必须和spring配置的信息一致.
        message.setTo(target);//接收者.
        message.setSubject(subject);//邮件主题.
        message.setText(text);//邮件内容.
        mailSender.send(message);//发送邮件
    }

}
