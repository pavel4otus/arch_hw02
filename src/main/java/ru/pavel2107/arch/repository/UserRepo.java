package ru.pavel2107.arch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail( String email);
}
