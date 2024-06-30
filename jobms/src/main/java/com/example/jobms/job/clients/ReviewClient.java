package com.example.jobms.job.clients;

import com.example.jobms.job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "reviewms", url = "${review-service.url}")
public interface ReviewClient {
    @GetMapping("/reviews")
    List<Review> reviewList(@RequestParam("companyId") Long companyId);
}
