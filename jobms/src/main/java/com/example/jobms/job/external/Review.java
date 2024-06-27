package com.example.jobms.job.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {
    private Long id;
    private String title;
    private String description;
    private double rating;
}
