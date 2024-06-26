package com.example.reviewms.review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAllByCompanyId(Long companyId);
    boolean createReview(Long companyId, Review review);
    Optional<Review> getReviewById(Long reviewId);
    boolean deleteReview(Long reviewId);
    boolean updateReview(Long reviewId, Review reviewUpdate);
}
