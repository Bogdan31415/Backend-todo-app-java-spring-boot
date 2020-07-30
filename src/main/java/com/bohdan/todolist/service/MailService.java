package com.bohdan.todolist.service;

import com.bohdan.todolist.exceptions.SpringToDoException;
import com.bohdan.todolist.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
class MailService {

    private final JavaMailSender emailSender;



    @Async
    void sendMail(NotificationEmail notificationEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("todo-f78006@inbox.mailtrap.io");
        message.setTo(notificationEmail.getRecipient());
        message.setSubject(notificationEmail.getSubject());
        message.setText(notificationEmail.getBody());
        try {
            emailSender.send(message);
            log.info("Activation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new SpringToDoException("Exception occurred when sending mail to " + notificationEmail.getRecipient(), e);
        }
    }
}