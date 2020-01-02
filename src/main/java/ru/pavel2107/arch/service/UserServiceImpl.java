package ru.pavel2107.arch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pavel2107.arch.domain.User;
import ru.pavel2107.arch.repository.UserRepo;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl( UserRepo repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerNewUser(User user) throws Exception {
        user.setOrders( null);
        user.setRole( "ROLE_USER");
        return repository.save( user);
    }

    @Override
    public User updateExisting(User user) throws Exception {
        return repository.save( user);
    }

    @Override
    public void disable(User user) {
        user.setActive( false);
        repository.save( user);
    }

    @Override
    public void enable(User user) {
        user.setActive( true);
        repository.save( user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail( email);
    }

    @Override
    public User find(Long id) {
        return repository.findById( id).orElse( null);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
