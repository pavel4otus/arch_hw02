package ru.pavel2107.arch.service;

public class PushServiceImpl implements PushService {
    @Override
    public void push(String phone, String text) {
        System.out.println( "Sending :" + text + " to:" + phone);
    }
}
