package ru.pavel2107.arch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pavel2107.arch.domain.Brand;
import ru.pavel2107.arch.service.BrandService;

import java.util.List;

@RestController
public class BrandController {

    private BrandService service;

    @Autowired
    public BrandController(BrandService service){
        this.service = service;
    }

    @GetMapping( value = "/rest/brands", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Brand> BrandList(){
        return  service.findAll();
    }

    @DeleteMapping( value = "/rest/brands")
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public void delete(@RequestParam( value = "id") Long id){
        service.delete( id);
    }

    @GetMapping( value = "/rest/brands/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Brand get(@PathVariable( value = "id") Long id){
        Brand Brand = service.find( id);
        return Brand;
    }

    @PutMapping( value = "/rest/brands", produces = MediaType.APPLICATION_JSON_VALUE)
    public Brand save(@RequestBody Brand brand){
        if( brand.getId() == 0 && service.findByCode( brand.getCode()) != null){
            throw new RuntimeException( "Brand with code " + brand.getCode() + " already exists");
        }
        Brand newBrand = service.save( brand);
        return newBrand;
    }
}
