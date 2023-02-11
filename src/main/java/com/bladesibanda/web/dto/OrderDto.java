package com.bladesibanda.web.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
  private Long id;
  private BigDecimal totalPrice;
  private String status;
  private ZonedDateTime shipped;
  private Long paymentId;
  private AddressDto shipmentAddress;
  private Set<OrderItemDto> orderItems;
  private CartDto cart;
}
