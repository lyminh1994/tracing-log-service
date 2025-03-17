package io.lifeberries.tracing_log_service.mongo.domain;

import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("logs")
public class Log {

  @Id private UUID id;

  @Size(max = 255)
  private String level;

  @Size(max = 255)
  private String service;

  @Size(max = 255)
  private String request;

  @Size(max = 255)
  private String response;

  @CreatedDate private OffsetDateTime dateCreated;

  @LastModifiedDate private OffsetDateTime lastUpdated;

  @Version private Integer version;
}
