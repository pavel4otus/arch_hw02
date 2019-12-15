package ru.pavel2107.arch.service;

import ru.pavel2107.arch.domain.Brand;

import java.util.List;

public interface BrandService {
    Brand save(Brand brand);
    void delete( Long id);
    Brand find( Long id);
    List<Brand> findByName( String name);
    List<Brand> findByCountryName( String name);
    List<Brand> findByCountryCode( String code);
    List<Brand> findAll();
}
