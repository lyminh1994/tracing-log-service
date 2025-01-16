package io.lifeberries.tracing_log_service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.lifeberries.tracing_log_service.domain")
@EnableJpaRepositories("io.lifeberries.tracing_log_service.repos")
@EnableTransactionManagement
public class DomainConfig {
}
