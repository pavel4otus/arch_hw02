package ru.pavel2107.arch.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.pavel2107.arch.domain.Brand;
import ru.pavel2107.arch.repository.BrandRepo;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    private BrandRepo repository;

    @Autowired
    public BrandServiceImpl( BrandRepo repository){
        this.repository = repository;
    }


    @Override
    public Brand save(Brand brand) {
        return repository.save( brand);
    }

    @Override
    public void delete(Long id) {
        Brand brand = find( id);
        if( brand != null){
            repository.delete( brand);
        }
    }

    @Override
    public List<Brand> findByName(String name) {
        return repository.findByName( name);
    }

    @Override
    public List<Brand> findByCountryName(String name) {
        return repository.findByCountryName( name);
    }

    @Override
    public List<Brand> findByCountryCode(String code) {
        return repository.findByCountryCode( code);
    }

    @Override
    public Brand find(Long id) {
        return repository.findById( id).orElse( null);
    }

    @Override
    public List<Brand> findAll() {
        return repository.findAll();
    }
}
