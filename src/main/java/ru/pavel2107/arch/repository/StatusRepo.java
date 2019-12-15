package ru.pavel2107.arch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.domain.Status;

public interface StatusRepo extends JpaRepository<Status, Long> {
}
