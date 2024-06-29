package com.example.companyms.company.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reviewms")
public interface ReviewClient {
    @GetMapping("/reviews/averageRating")
    public Double getAverageRating(@RequestParam("companyId") Long companyId);
}
