package ru.levchenko.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchenko.models.User;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);
    Optional<User> findOneByLogin(String login);
}
