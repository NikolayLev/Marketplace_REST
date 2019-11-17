package ru.levchenko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchenko.models.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

}
