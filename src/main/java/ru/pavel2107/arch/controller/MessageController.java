package ru.pavel2107.arch.controller;

import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pavel2107.arch.service.SendMessage;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {

    private SendMessage messageService;

    @Autowired
    public MessageController( SendMessage messageService){
        this.messageService = messageService;
    }

    @PostMapping( value = "/rest/send")
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public void send(@RequestBody HashMap<String,String>  properties){
        String destination = (String) properties.get( "destination");
        messageService.send( destination, properties);
    }

}
