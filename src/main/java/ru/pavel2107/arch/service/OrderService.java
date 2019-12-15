package ru.pavel2107.arch.service;

import ru.pavel2107.arch.domain.Order;
import ru.pavel2107.arch.domain.User;

import java.util.List;

public interface OrderService {
    Order save(Order good);
    void delete( Long id);
    Order find( Long id);
    List<Order> findAll();
    List<Order> findByUser(User user);
}
