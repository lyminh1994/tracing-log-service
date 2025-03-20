package io.lifeberries.tracing_log_service.repos;

import io.lifeberries.tracing_log_service.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
