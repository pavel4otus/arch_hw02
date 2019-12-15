package ru.pavel2107.arch.service;

import java.util.Map;

public interface SendMessage {
    void send(String destination, Map<String, Object> properties);
}
