package io.lifeberries.tracing_log_service.postgres.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

  @Id private Integer id;
  private String name;
  private String link;
  private String image;
  private BigDecimal price;
}
