package ru.pavel2107.arch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pavel2107.arch.domain.Country;
import ru.pavel2107.arch.service.CountryService;

import java.util.List;

@RestController
public class CountryController {

    private CountryService service;

    @Autowired
    public CountryController( CountryService service){
        this.service = service;
    }

    @GetMapping( value = "/rest/country", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> listCountries(){
        List <Country> list = service.findAll();
        return  list;
    }

    @DeleteMapping( value = "/rest/country")
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public void delete(@RequestParam( value = "id") Long id){
        service.delete( id);
    }

    @GetMapping( value = "/rest/country/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country get( @PathVariable( value = "id") Long id){
        Country Country= service.find( id);
        return Country;
    }

    @PutMapping( value = "/rest/country", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country save( @RequestBody Country Country){
        Country newCountry = service.save( Country);
        return newCountry;
    }

}
