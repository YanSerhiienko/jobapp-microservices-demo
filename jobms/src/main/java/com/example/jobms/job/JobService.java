package com.example.jobms.job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAllJobs();
    void createJob(Job job);
    Optional<Job> getJobById(Long id);
    boolean deleteJob(Long id);
    boolean updateJob(Long id, Job jobUpdate);
}
