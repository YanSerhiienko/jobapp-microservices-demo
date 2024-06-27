package com.example.jobms.job;

import com.example.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> findAllJobs();
    void createJob(Job job);
    JobDTO getJobById(Long id);
    boolean deleteJob(Long id);
    boolean updateJob(Long id, Job jobUpdate);
}
