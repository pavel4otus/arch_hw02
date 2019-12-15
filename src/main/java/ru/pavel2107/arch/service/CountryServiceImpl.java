package ru.pavel2107.arch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.arch.domain.Country;
import ru.pavel2107.arch.repository.CountryRepo;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepo repository;

    @Autowired
    public CountryServiceImpl( CountryRepo repository){
        this.repository = repository;
    }


    @Override
    public Country save(Country country) {
        return repository.save( country);
    }

    @Override
    public void delete(Long id) {
        Country country = find( id);
        if( country != null){
            repository.delete( country);
        }
    }

    @Override
    public Country find(Long id) {
        return repository.findById( id).orElse( null);
    }

    @Override
    public Country findByName(String name) {
        return repository.findByName( name);
    }

    @Override
    public Country findByCode(String code) {
        return findByCode( code);
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

}
