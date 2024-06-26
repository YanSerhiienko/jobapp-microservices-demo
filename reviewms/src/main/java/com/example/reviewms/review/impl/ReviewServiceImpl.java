package com.example.reviewms.review.impl;


import com.example.reviewms.review.Review;
import com.example.reviewms.review.ReviewRepository;
import com.example.reviewms.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;


    @Override
    public List<Review> findAllByCompanyId(Long companyId) {
        return reviewRepository.findAll();
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        if (companyId != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            //Review review = reviewRepository.findById(reviewId).get();
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long reviewId, Review reviewUpdate) {
        //Optional<Review> reviewOptional = reviewRepository.findByCompanyIdAndReviewId(companyId, reviewId);
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            review.setTitle(reviewUpdate.getTitle());
            review.setDescription(reviewUpdate.getDescription());
            review.setRating(reviewUpdate.getRating());
            review.setCompanyId(reviewUpdate.getCompanyId());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }
}
