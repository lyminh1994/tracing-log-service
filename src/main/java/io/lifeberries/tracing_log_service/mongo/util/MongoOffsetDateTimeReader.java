package io.lifeberries.tracing_log_service.mongo.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

public class MongoOffsetDateTimeReader implements Converter<Document, OffsetDateTime> {

  @Override
  public OffsetDateTime convert(final Document document) {
    final var dateTime = document.getDate(MongoOffsetDateTimeWriter.DATE_FIELD);
    final var offset = ZoneOffset.of(document.getString(MongoOffsetDateTimeWriter.OFFSET_FIELD));
    return OffsetDateTime.ofInstant(dateTime.toInstant(), offset);
  }
}
