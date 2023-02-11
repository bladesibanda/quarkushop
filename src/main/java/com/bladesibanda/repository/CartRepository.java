package com.bladesibanda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bladesibanda.domain.Cart;
import com.bladesibanda.domain.enums.CartStatus;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  List<Cart> findByStatus(CartStatus status);

  List<Cart> findByStatusAndCustomerId(CartStatus status, Long customerId);
}
