package io.lifeberries.tracing_log_service.mapper;

import io.lifeberries.tracing_log_service.dto.LogDTO;
import io.lifeberries.tracing_log_service.mongo.domain.Log;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LogMapper {

  LogMapper INSTANCE = Mappers.getMapper(LogMapper.class);

  LogDTO toLogDTO(Log log);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "lastUpdated", ignore = true)
  @Mapping(target = "dateCreated", ignore = true)
  Log toLog(LogDTO logDTO);

  @Mapping(target = "version", ignore = true)
  @Mapping(target = "lastUpdated", ignore = true)
  @Mapping(target = "dateCreated", ignore = true)
  Log toLog(LogDTO logDTO, @MappingTarget Log log);
}
