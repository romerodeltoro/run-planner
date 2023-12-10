package ru.runplanner.user.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.runplanner.user.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
