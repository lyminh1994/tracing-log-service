package io.lifeberries.tracing_log_service.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

@Component
@RequiredArgsConstructor
public class WebUtils {

  public static final String MSG_SUCCESS = "MSG_SUCCESS";
  public static final String MSG_INFO = "MSG_INFO";
  public static final String MSG_ERROR = "MSG_ERROR";

  private final MessageSource messageSource;
  private final LocaleResolver localeResolver;
  private final HttpServletRequest httpServletRequest;

  public String getMessage(final String code, final Object... args) {
    return messageSource.getMessage(
        code, args, code, localeResolver.resolveLocale(httpServletRequest));
  }
}
