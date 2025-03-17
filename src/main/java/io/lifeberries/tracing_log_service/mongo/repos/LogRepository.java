package io.lifeberries.tracing_log_service.mongo.repos;

import io.lifeberries.tracing_log_service.mongo.domain.Log;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, UUID> {}
