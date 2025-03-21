package io.lifeberries.tracing_log_service.config;

import io.lifeberries.tracing_log_service.mongo.util.MongoOffsetDateTimeReader;
import io.lifeberries.tracing_log_service.mongo.util.MongoOffsetDateTimeWriter;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@EnableMongoRepositories("io.lifeberries.tracing_log_service.mongo.repos")
@EnableMongoAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
public class MongoConfig {

  @Bean
  public MongoTransactionManager transactionManager(final MongoDatabaseFactory databaseFactory) {
    return new MongoTransactionManager(databaseFactory);
  }

  @Bean
  public ValidatingMongoEventListener validatingMongoEventListener(
      final LocalValidatorFactoryBean factory) {
    return new ValidatingMongoEventListener(factory);
  }

  @Bean
  public MongoCustomConversions mongoCustomConversions() {
    return new MongoCustomConversions(
        Arrays.asList(new MongoOffsetDateTimeWriter(), new MongoOffsetDateTimeReader()));
  }
}
