package io.lifeberries.tracing_log_service.dto;

import io.lifeberries.tracing_log_service.enums.LogLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LogDTO(
    @Size(max = 255) LogLevel level,
    @Size(max = 255) @NotBlank(message = "{error.message}") String service,
    @Size(max = 255) String request,
    @Size(max = 255) String response) {}
