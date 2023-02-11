package com.bladesibanda.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.bladesibanda.domain.Order;
import com.bladesibanda.domain.Payment;
import com.bladesibanda.domain.enums.OrderStatus;
import com.bladesibanda.domain.enums.PaymentStatus;
import com.bladesibanda.repository.OrderRepository;
import com.bladesibanda.repository.PaymentRepository;
import com.bladesibanda.web.dto.PaymentDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@Transactional
public class PaymentService {
  @Inject
  PaymentRepository paymentRepository;

  @Inject
  OrderRepository orderRepository;

  public static PaymentDto mapToDto(Payment payment, Long orderId) {
    if (payment != null) {
      return new PaymentDto(payment.getId(),
          orderId, payment.getPaypalPaymentId(),
          payment.getStatus().name());
    }
    return null;
  }

  public List<PaymentDto> findByPriceRange(Double max) {
    return this.paymentRepository
        .findAllByAmountBetween(BigDecimal.ZERO, BigDecimal.valueOf(max))
        .stream()
        .map(payment -> mapToDto(payment, findOrderByPaymentId(payment.getId()).getId()))
        .collect(Collectors.toList());
  }

  public List<PaymentDto> findAll() {
    log.debug("Request to get all Payments");
    return this.paymentRepository.findAll()
        .stream().map(payment -> findById(payment.getId()))
        .collect(Collectors.toList());
  }

  public PaymentDto findById(Long id) {
    log.debug("Request to get Payment : {}", id);
    var order = findOrderByPaymentId(id);
    return this.paymentRepository
        .findById(id)
        .map(payment -> mapToDto(payment, order.getId()))
        .orElse(null);
  }

  public PaymentDto create(PaymentDto paymentDto) {
    log.debug("Request to create Payment : {}", paymentDto);
    var order = this.orderRepository.findById(paymentDto.getOrderId())
        .orElseThrow(() -> new IllegalStateException("The Order does not exist!"));
    order.setStatus(OrderStatus.PAID);
    var payment = this.paymentRepository.saveAndFlush(
        new Payment(paymentDto.getPaypalPaymentId(),
            PaymentStatus.valueOf(paymentDto.getStatus()),
            order.getPrice()));
    this.orderRepository.saveAndFlush(order);
    return mapToDto(payment, order.getId());
  }

  public void delete(Long id) {
    log.debug("Request to delete Payment : {}", id);
    this.paymentRepository.deleteById(id);
  }

  private Order findOrderByPaymentId(Long id) {
    return this.orderRepository.findByPaymentId(id)
        .orElseThrow(() -> new IllegalStateException("No Order exists for the Payment ID " + id));
  }
}
