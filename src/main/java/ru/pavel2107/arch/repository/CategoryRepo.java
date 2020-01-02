package ru.pavel2107.arch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.domain.Category;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
    Category findByCode( String code);
}
