package com.mashood.telecom.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailSender {


    @Value("${birthday.message.subject}")
    private String subject;
    @Value("${birthday.message.send.from}")
    private String sendFrom;

    private final JavaMailSender mailSender;



    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    @Async
    public void send(String to, String emailContent) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setText(emailContent,true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(sendFrom);
            mailSender.send(mimeMessage);
        } catch (MessagingException e){
            throw new IllegalStateException("Fail to send Email");
        }
    }



}
