package io.lifeberries.tracing_log_service.postgres.repos;

import io.lifeberries.tracing_log_service.postgres.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
