package com.bladesibanda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bladesibanda.domain.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
  List<OrderItem> findAllByOrderId(Long id);
}
