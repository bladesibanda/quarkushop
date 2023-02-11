package com.bladesibanda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bladesibanda.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
  @Query("select p.reviews from Product p where p.id = ?1")
  List<Review> findReviewsByProductId(Long id);
}
