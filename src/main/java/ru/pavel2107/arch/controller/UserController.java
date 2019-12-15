package ru.pavel2107.arch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pavel2107.arch.domain.User;
import ru.pavel2107.arch.service.UserService;

import java.util.List;

@RestController
public class UserController {


    private UserService service;

    @Autowired
    public UserController( UserService service){
        this.service = service;
    }

    @GetMapping( value = "/rest/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listUsers(){
        List <User> list = service.findAll();
        return  list;
    }


    @GetMapping( value = "/rest/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get( @PathVariable( value = "id") Long id){
        User user = service.find( id);
        return user;
    }

    @GetMapping( value = "/rest/users/findByEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public User findByEmail( @RequestParam( name = "email") String email ){
        return service.findByEmail( email);
    }

    @PutMapping( value = "/rest/users/disable", produces = MediaType.APPLICATION_JSON_VALUE)
    public User disable( @RequestBody User user){
         service.disable( user);
         return service.find( user.getId());
    }

    @PutMapping( value = "/rest/users/enable", produces = MediaType.APPLICATION_JSON_VALUE)
    public User enable( @RequestBody User user){
        service.enable( user);
        return service.find( user.getId());
    }


    @PostMapping( value = "/rest/users/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public User register( @RequestBody User user) throws Exception{
        User newUser = service.registerNewUser( user);
        return newUser;
    }

    @PutMapping( value = "/rest/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateExisting( @RequestBody User user) throws Exception{
        User newUser = service.updateExisting( user);
        return newUser;
    }


}


/*
    User updateExisting(  User user)throws Exception;
 */