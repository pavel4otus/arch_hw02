package ru.pavel2107.arch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
