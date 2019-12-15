package ru.pavel2107.arch.service;

import ru.pavel2107.arch.domain.Good;

import java.util.List;

public interface GoodsService {
    Good save( Good good);
    void delete( Long id);
    Good find( Long id);
    List<Good> findByName( String name);
    Good findBySkud( Long skud);
    List<Good> findAll();
}
