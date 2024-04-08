package com.Boot;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}