package io.lifeberries.tracing_log_service.service;

import io.lifeberries.tracing_log_service.dto.LogDTO;
import java.util.List;
import java.util.UUID;

public interface LogService {

  List<LogDTO> findAll();

  LogDTO get(final UUID id);

  UUID create(final LogDTO logsDTO);

  void update(final UUID id, final LogDTO logsDTO);

  void delete(final UUID id);
}
