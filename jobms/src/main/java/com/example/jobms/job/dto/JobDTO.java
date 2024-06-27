package com.example.jobms.job.dto;

import com.example.companyms.company.Company;
import com.example.jobms.job.Job;
import com.example.jobms.job.external.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    private List<Review> reviews;
}
