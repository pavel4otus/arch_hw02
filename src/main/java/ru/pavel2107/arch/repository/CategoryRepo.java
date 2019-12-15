package ru.pavel2107.arch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.domain.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
