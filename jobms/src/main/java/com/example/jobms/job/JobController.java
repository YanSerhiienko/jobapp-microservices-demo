package com.example.jobms.job;

import com.example.jobms.job.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll() {
        return new ResponseEntity<>(jobService.findAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        JobDTO jobDTO = jobService.getJobById(id);
        if (jobDTO != null) {
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJob(id);
        if (isDeleted) {
            return new ResponseEntity<>("Job has been deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job with such id not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job jobUpdate) {
        boolean isUpdated = jobService.updateJob(id, jobUpdate);
        if (isUpdated) {
            return new ResponseEntity<>("Job has been updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job with such id not found", HttpStatus.NOT_FOUND);
    }

    /*@GetMapping("/jobs/{id}")
    public List<Job> getCompany() {
        return jobs;
    }*/
}
