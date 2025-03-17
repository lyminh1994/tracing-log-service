package io.lifeberries.tracing_log_service.config;

import java.util.Objects;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

/** Load Thymeleaf files from the file system during development, without any caching. */
@Configuration
@Profile("local")
public class LocalDevConfig {

  @SneakyThrows
  public LocalDevConfig(final TemplateEngine templateEngine) {
    final var applicationYml = new ClassPathResource("application.yml");
    if (applicationYml.isFile()) {
      var sourceRoot = applicationYml.getFile().getParentFile();
      while (Objects.requireNonNull(sourceRoot.listFiles((dir, name) -> name.equals("mvnw"))).length
          != 1) {
        sourceRoot = sourceRoot.getParentFile();
      }
      final var fileTemplateResolver = new FileTemplateResolver();
      fileTemplateResolver.setPrefix(sourceRoot.getPath() + "/src/main/resources/templates/");
      fileTemplateResolver.setSuffix(".html");
      fileTemplateResolver.setCacheable(false);
      fileTemplateResolver.setCharacterEncoding("UTF-8");
      fileTemplateResolver.setCheckExistence(true);
      templateEngine.setTemplateResolver(fileTemplateResolver);
    }
  }
}
