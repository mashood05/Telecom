package com.mashood.telecom;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class TelecomApplication {

    // javaMail Configration values, reading from the application.properties
    @Value("${maildev.hostname}")
    String hostName;
    @Value("${maildev.port}")
    int port;

    public static void main(String[] args) {
        SpringApplication.run(TelecomApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setPort(port);
        javaMailSender.setProtocol("smtp");
        javaMailSender.setHost(hostName);
        javaMailSender.setUsername("hello");
        javaMailSender.setPassword("hello");
        return javaMailSender;
    }

}
