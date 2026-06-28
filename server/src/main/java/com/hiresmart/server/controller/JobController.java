package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.JobRequest;
import com.hiresmart.server.dto.response.JobResponse;
import com.hiresmart.server.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<String> createJob(
            @RequestBody JobRequest request) {

        return ResponseEntity.ok(
                jobService.createJob(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<JobResponse>> getAllJobs() {

        return ResponseEntity.ok(
                jobService.getAllJobs()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getJobById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                jobService.getJobById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(
            @PathVariable Integer id,
            @RequestBody JobRequest request) {

        return ResponseEntity.ok(
                jobService.updateJob(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                jobService.deleteJob(id)
        );
    }

}