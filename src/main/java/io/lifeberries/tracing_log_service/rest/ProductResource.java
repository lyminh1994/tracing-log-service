package io.lifeberries.tracing_log_service.rest;

import io.lifeberries.tracing_log_service.dto.ProductDto;
import io.lifeberries.tracing_log_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("productApi")
@RequestMapping(value = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductResource {

  private final ProductService productService;

  @GetMapping
  public Page<ProductDto> getProducts(@PageableDefault Pageable pageable) {
    return productService.getAllProduct(pageable);
  }
}
