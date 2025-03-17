package io.lifeberries.tracing_log_service.controller;

import io.lifeberries.tracing_log_service.dto.LogDTO;
import io.lifeberries.tracing_log_service.enums.LogLevel;
import io.lifeberries.tracing_log_service.service.LogService;
import io.lifeberries.tracing_log_service.util.WebUtils;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/logs")
public class LogController {

  private final WebUtils webUtils;
  private final LogService logService;

  @GetMapping
  public String list(final Model model) {
    model.addAttribute("logs", logService.findAll());
    return "logs/index";
  }

  @GetMapping("/add")
  public String add(final Model model, @ModelAttribute("log") final LogDTO logsDTO) {
    model.addAttribute("levelValues", LogLevel.values());
    return "logs/add";
  }

  @PostMapping("/add")
  public String add(
      @ModelAttribute("log") @Valid final LogDTO logsDTO,
      final BindingResult bindingResult,
      final RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      return "logs/add";
    }

    logService.create(logsDTO);
    redirectAttributes.addFlashAttribute(
        WebUtils.MSG_SUCCESS, webUtils.getMessage("log.create.success"));
    return "redirect:/logs";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable(name = "id") final UUID id, final Model model) {
    model.addAttribute("levelValues", LogLevel.values());
    model.addAttribute("log", logService.get(id));
    return "logs/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(
      @PathVariable(name = "id") final UUID id,
      @ModelAttribute("log") @Valid final LogDTO logsDTO,
      final BindingResult bindingResult,
      final RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      return "logs/edit";
    }
    logService.update(id, logsDTO);
    redirectAttributes.addFlashAttribute(
        WebUtils.MSG_SUCCESS, webUtils.getMessage("log.update.success"));
    return "redirect:/logs";
  }

  @PostMapping("/delete/{id}")
  public String delete(
      @PathVariable(name = "id") final UUID id, final RedirectAttributes redirectAttributes) {
    logService.delete(id);
    redirectAttributes.addFlashAttribute(
        WebUtils.MSG_INFO, webUtils.getMessage("log.delete.success"));
    return "redirect:/logs";
  }
}
