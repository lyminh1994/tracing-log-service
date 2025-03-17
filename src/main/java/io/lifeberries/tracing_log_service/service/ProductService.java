package io.lifeberries.tracing_log_service.service;

import io.lifeberries.tracing_log_service.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
  Page<ProductDto> getAllProduct(Pageable pageable);
}
