package ru.pavel2107.arch.service;

import ru.pavel2107.arch.domain.User;

import java.util.List;

public interface UserService {

    User registerNewUser( User user)throws Exception;
    User updateExisting(  User user)throws Exception;
    void disable( User user);
    void enable(  User user);
    User findByEmail( String email);
    User find( Long id);

    List<User > findAll();
}
