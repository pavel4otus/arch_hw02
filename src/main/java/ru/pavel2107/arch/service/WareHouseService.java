package ru.pavel2107.arch.service;

import ru.pavel2107.arch.domain.WareHouse;

import java.util.List;

public interface WareHouseService {
    WareHouse save(WareHouse wareHouse);
    void delete( Long id);
    WareHouse find(Long id);
    List<WareHouse> findAll();
}
