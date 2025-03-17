package io.lifeberries.tracing_log_service.controller;

import io.lifeberries.tracing_log_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public String getProducts(
      final Model model,
      @PageableDefault(
              size = 999,
              sort = {"price"})
          final Pageable pageable) {
    model.addAttribute("products", productService.getAllProduct(pageable));
    return "products/index";
  }
}
