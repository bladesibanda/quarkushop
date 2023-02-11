package com.bladesibanda.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
  private Long id, orderId;
  private String paypalPaymentId, status;
}
