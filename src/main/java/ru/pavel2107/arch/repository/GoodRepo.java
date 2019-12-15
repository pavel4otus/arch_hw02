package ru.pavel2107.arch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.domain.Good;

import java.util.List;

public interface GoodRepo extends JpaRepository<Good, Long> {
    List<Good> findByName(String name);
    Good findBySkud( Long skud);
}
