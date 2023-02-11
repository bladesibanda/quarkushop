package com.bladesibanda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bladesibanda.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  List<Order> findByCartCustomerId(Long customerId);

  Optional<Order> findByPaymentId(Long id);
}
