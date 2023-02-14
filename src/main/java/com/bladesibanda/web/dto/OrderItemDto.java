package com.bladesibanda.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
  private Long id;

  @NotNull
  private Long quantity;

  @NotNull
  private Long productId;

  @NotNull
  private Long orderId;
}
