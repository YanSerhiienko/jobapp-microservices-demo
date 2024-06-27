package com.example.jobms.job.dto;

import com.example.companyms.company.Company;
import com.example.jobms.job.Job;
import com.example.jobms.job.external.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobMapper {
    public JobDTO mapToJobDTO(Job job, Company company, List<Review> reviews) {
        return JobDTO.builder()
                .id(job.getId())
                .title(job.getTitle())
                .location(job.getLocation())
                .description(job.getDescription())
                .minSalary(job.getMinSalary())
                .maxSalary(job.getMaxSalary())
                .company(company)
                .reviews(reviews)
                .build();
    }
}
