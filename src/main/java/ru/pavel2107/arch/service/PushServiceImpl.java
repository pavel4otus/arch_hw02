package ru.pavel2107.arch.service;

import org.springframework.stereotype.Service;

@Service
public class PushServiceImpl implements PushService {
    @Override
    public void push(String phone, String text) {
        System.out.println( "Sending :" + text + " to:" + phone);
    }
}
