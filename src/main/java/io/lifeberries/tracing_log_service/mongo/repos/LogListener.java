package io.lifeberries.tracing_log_service.mongo.repos;

import io.lifeberries.tracing_log_service.mongo.domain.Log;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class LogListener extends AbstractMongoEventListener<Log> {

  @Override
  public void onBeforeConvert(final BeforeConvertEvent<Log> event) {
    if (event.getSource().getId() == null) {
      event.getSource().setId(UUID.randomUUID());
    }
  }
}
