package ru.pavel2107.arch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pavel2107.arch.domain.WareHouse;
import ru.pavel2107.arch.service.WareHouseService;

import java.util.List;

@RestController
public class WareHouseController {

    private WareHouseService service;

    @Autowired
    public WareHouseController(WareHouseService service){
        this.service = service;
    }

    @GetMapping( value = "/rest/warehouses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WareHouse> wareHouseList(){
        List <WareHouse> list = service.findAll();
        return  list;
    }

    @DeleteMapping( value = "/rest/warehouses")
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public void delete(@RequestParam( value = "id") Long id){
        service.delete( id);
    }

    @GetMapping( value = "/rest/warehouses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WareHouse get(@PathVariable( value = "id") Long id){
        WareHouse wareHouse = service.find( id);
        return wareHouse;
    }

    @PutMapping( value = "/rest/warehouses", produces = MediaType.APPLICATION_JSON_VALUE)
    public WareHouse save(@RequestBody WareHouse wareHouse){
        WareHouse newWareHouse = service.save(wareHouse);
        return newWareHouse;
    }
}
