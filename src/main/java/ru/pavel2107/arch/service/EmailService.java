package ru.pavel2107.arch.service;

public interface EmailService {
    void send( String to, String subject, String text);
}
