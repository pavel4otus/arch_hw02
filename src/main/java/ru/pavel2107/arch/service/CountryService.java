package ru.pavel2107.arch.service;

import ru.pavel2107.arch.domain.Country;

import java.util.List;

public interface CountryService {

    Country save(Country country);
    void delete( Long id);
    Country find( Long id);
    Country findByName(String name);
    Country findByCode( String code);
    List<Country> findAll();
}
