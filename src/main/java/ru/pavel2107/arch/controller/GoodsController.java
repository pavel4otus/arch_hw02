package ru.pavel2107.arch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pavel2107.arch.domain.Good;
import ru.pavel2107.arch.service.GoodsService;

import java.util.List;

@RestController
public class GoodsController {

    private GoodsService service;

    @Autowired
    public GoodsController( GoodsService service){
        this.service = service;
    }

    @GetMapping( value = "/rest/goods", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Good> listGoods(){
        List <Good> list = service.findAll();
        return  list;
    }

    @DeleteMapping( value = "/rest/goods")
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public void delete(@RequestParam( value = "id") Long id){
        service.delete( id);
    }

    @GetMapping( value = "/rest/goods/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Good get( @PathVariable( value = "id") Long id){
        Good good = service.find( id);
        return good;
    }

    @PutMapping( value = "/rest/goods", produces = MediaType.APPLICATION_JSON_VALUE)
    public Good save( @RequestBody Good good){
        Good newGood = service.save( good);
        return newGood;
    }

}
