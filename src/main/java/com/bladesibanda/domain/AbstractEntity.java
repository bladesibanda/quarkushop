package com.bladesibanda.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/*
 * Base Entity class for entities which will hold creation and last modification date.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "created_date", nullable = false)
  private Instant createdDate;

  @Column(name = "last_modified_date")
  private Instant lastModifiedDate;
}
