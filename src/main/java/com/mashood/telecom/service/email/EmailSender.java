package com.mashood.telecom.service.email;

public interface EmailSender {
    void send(String to, String emailContent);
}
