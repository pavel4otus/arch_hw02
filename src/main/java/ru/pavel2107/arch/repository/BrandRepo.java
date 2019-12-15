package ru.pavel2107.arch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.domain.Brand;

import java.util.List;

public interface BrandRepo extends JpaRepository<Brand, Long> {
    List<Brand> findByName(String name);
    List<Brand> findByCountryName( String name);
    List<Brand> findByCountryCode( String name);
}
