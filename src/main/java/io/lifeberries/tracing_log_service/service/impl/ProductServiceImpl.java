package io.lifeberries.tracing_log_service.service.impl;

import io.lifeberries.tracing_log_service.dto.ProductDto;
import io.lifeberries.tracing_log_service.postgres.repos.ProductRepository;
import io.lifeberries.tracing_log_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Page<ProductDto> getAllProduct(Pageable pageable) {
    return productRepository
        .findAll(pageable)
        .map(
            product ->
                new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getLink(),
                    product.getImage(),
                    product.getPrice()));
  }
}
