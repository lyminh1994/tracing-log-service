package io.lifeberries.tracing_log_service;

import java.lang.management.ManagementFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableCaching
@SpringBootApplication
@ConfigurationPropertiesScan
public class TracingLogServiceApplication {

  public static void main(final String[] args) {
    String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
    MDC.put("pid", pid);
    MDC.put("serviceName", "OrderService");

    SpringApplication.run(TracingLogServiceApplication.class, args);
  }
}
