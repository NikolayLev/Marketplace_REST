package ru.levchenko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.levchenko.models.User;

import java.util.Optional;
@Component
public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByLogin(String login);
    Optional<User> findOneByActivationCode(String activationCode);

}
