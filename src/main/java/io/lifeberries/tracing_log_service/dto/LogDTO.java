package io.lifeberries.tracing_log_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogDTO {

  private UUID id;
  private @Size(max = 255) String level;
  private @Size(max = 255) @NotBlank(message = "{error.message}") String service;
  private @Size(max = 255) String request;
  private @Size(max = 255) String response;
}
