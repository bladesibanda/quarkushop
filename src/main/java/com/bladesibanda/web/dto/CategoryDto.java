package com.bladesibanda.web.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String description;
  private Long products;
}
