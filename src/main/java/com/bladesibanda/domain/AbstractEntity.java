package com.bladesibanda.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

class AuditingEntityListener {
  @PrePersist
  void preCreate(AbstractEntity auditable) {
    Instant now = Instant.now();
    auditable.setCreatedDate(now);
    auditable.setLastModifiedDate(now);
  }

  @PreUpdate
  void preUpdate(AbstractEntity auditable) {
    Instant now = Instant.now();
    auditable.setLastModifiedDate(now);
  }
}

/*
 * Base Entity class for entities which will hold creation and last modification
 * date.
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "created_date", nullable = false)
  private Instant createdDate;

  @Column(name = "last_modified_date")
  private Instant lastModifiedDate;
}
