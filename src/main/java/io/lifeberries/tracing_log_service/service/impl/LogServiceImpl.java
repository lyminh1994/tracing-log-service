package io.lifeberries.tracing_log_service.service.impl;

import io.lifeberries.tracing_log_service.dto.LogDTO;
import io.lifeberries.tracing_log_service.exception.NotFoundException;
import io.lifeberries.tracing_log_service.mapper.LogMapper;
import io.lifeberries.tracing_log_service.mongo.repos.LogRepository;
import io.lifeberries.tracing_log_service.service.LogService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

  private final LogRepository logRepository;

  @Override
  public List<LogDTO> findAll() {
    final var logs = logRepository.findAll(Sort.by("id"));
    return logs.stream().map(LogMapper.INSTANCE::toLogDTO).toList();
  }

  @Override
  public LogDTO get(final UUID id) {
    return logRepository
        .findById(id)
        .map(LogMapper.INSTANCE::toLogDTO)
        .orElseThrow(NotFoundException::new);
  }

  @Override
  public UUID create(final LogDTO logDTO) {
    final var log = LogMapper.INSTANCE.toLog(logDTO);
    return logRepository.save(log).getId();
  }

  @Override
  public void update(final UUID id, final LogDTO logDTO) {
    final var log = logRepository.findById(id).orElseThrow(NotFoundException::new);
    var updateLog = LogMapper.INSTANCE.toLog(logDTO, log);
    logRepository.save(updateLog);
  }

  @Override
  public void delete(final UUID id) {
    logRepository.deleteById(id);
  }
}
