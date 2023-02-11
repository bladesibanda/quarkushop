package com.bladesibanda.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.bladesibanda.domain.enums.CartStatus;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "carts")
public class Cart extends AbstractEntity {
  @ManyToOne
  private Customer customer;

  @NotNull
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private CartStatus status;
}
