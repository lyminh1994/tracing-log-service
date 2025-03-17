package io.lifeberries.tracing_log_service.dto;

import java.math.BigDecimal;

public record ProductDto(Integer id, String name, String link, String image, BigDecimal price) {}
