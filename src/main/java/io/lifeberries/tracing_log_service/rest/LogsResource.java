package io.lifeberries.tracing_log_service.rest;

import io.lifeberries.tracing_log_service.dto.LogDTO;
import io.lifeberries.tracing_log_service.service.LogService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/logs", produces = MediaType.APPLICATION_JSON_VALUE)
public class LogsResource {

  private final LogService logService;

  @GetMapping
  public ResponseEntity<List<LogDTO>> getAllLogs() {
    return ResponseEntity.ok(logService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<LogDTO> getLog(@PathVariable(name = "id") final UUID id) {
    return ResponseEntity.ok(logService.get(id));
  }

  @PostMapping
  public ResponseEntity<UUID> createLog(@RequestBody @Valid final LogDTO logDTO) {
    final var createdId = logService.create(logDTO);
    return new ResponseEntity<>(createdId, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UUID> updateLog(
      @PathVariable(name = "id") final UUID id, @RequestBody @Valid final LogDTO logDTO) {
    logService.update(id, logDTO);
    return ResponseEntity.ok(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLog(@PathVariable(name = "id") final UUID id) {
    logService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
