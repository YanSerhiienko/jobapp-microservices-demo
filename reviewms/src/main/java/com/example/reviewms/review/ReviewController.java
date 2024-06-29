package com.example.reviewms.review;

import com.example.reviewms.review.messaging.ReviewMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMessageProducer messageProducer;

    @GetMapping
    public ResponseEntity<List<Review>> findAll(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.findAllByCompanyId(companyId), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        Optional<Review> review = reviewService.getReviewById(reviewId);
        if (review.isPresent()) {
            return new ResponseEntity<>(review.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        boolean isAdded = reviewService.createReview(companyId, review);
        if (isAdded) {
            messageProducer.sendMessage(review);
            return new ResponseEntity<>("Review added", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company with such id not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        boolean isDeleted = reviewService.deleteReview(reviewId);
        if (isDeleted) {
            return new ResponseEntity<>("Review has been deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review with such id not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review reviewUpdate) {
        boolean isUpdated = reviewService.updateReview(reviewId, reviewUpdate);
        if (isUpdated) {
            return new ResponseEntity<>("Review has been updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review with such id not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/averageRating")
    public Double getAverageRating(@RequestParam Long companyId) {
        List<Review> reviewList = reviewService.findAllByCompanyId(companyId);
        return reviewList.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }
}
