package ru.levchenko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchenko.models.Token;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findOneByValue(String value);
}
