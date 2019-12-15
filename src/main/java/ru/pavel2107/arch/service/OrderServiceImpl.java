package ru.pavel2107.arch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.arch.domain.Order;
import ru.pavel2107.arch.domain.User;
import ru.pavel2107.arch.repository.OrderRepo;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepo repository;

    @Autowired
    public OrderServiceImpl( OrderRepo repository){
        this.repository = repository;;
    }


    @Override
    public Order save(Order good) {
        return repository.save( good);
    }

    @Override
    public void delete(Long id) {
        Order order = find( id);
        if( order != null){
            repository.delete( order);
        }
    }

    @Override
    public Order find(Long id) {
        return repository.findById( id).orElse( null);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Order> findByUser(User user) {
        return repository.findByUser( user);
    }
}
