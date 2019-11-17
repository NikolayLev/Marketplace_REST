package ru.levchenko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchenko.models.Product;
import ru.levchenko.models.State;
import ru.levchenko.models.User;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    Optional<Product> findOneByOwnerId(Long id);

    Optional<Product> findOneByName(Long id);

    List<Product> findAllByStatus(State state);

    List<Product> findAllByStatusAndOwner(State state, User user);
}
