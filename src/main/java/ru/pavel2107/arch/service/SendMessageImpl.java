package ru.pavel2107.arch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SendMessageImpl implements SendMessage {

    private PushService  pushService;
    private EmailService emailService;

    @Autowired
    public SendMessageImpl( PushService pushService, EmailService emailService){
        this.emailService = emailService;
        this.pushService  = pushService;
    }


    @Override
    public void send(String destination, Map<String, String> properties) {
        switch ( destination){
           case "push":
               String phone      = properties.get( "phone");
               String message    = properties.get( "message");
               pushService.push( phone, message);
               break;
            case "email":
                String to      = properties.get( "to");
                String subject = properties.get( "subject");
                String text    = properties.get( "text");
                emailService.send( to, subject, text);
                break;
        }
    }
}
