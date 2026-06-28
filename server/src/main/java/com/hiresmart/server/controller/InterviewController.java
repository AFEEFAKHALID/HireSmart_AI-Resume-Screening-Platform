package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.InterviewRequest;
import com.hiresmart.server.dto.response.InterviewResponse;
import com.hiresmart.server.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    public ResponseEntity<String> scheduleInterview(
            @RequestBody InterviewRequest request) {

        return ResponseEntity.ok(
                interviewService.scheduleInterview(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<InterviewResponse>> getAllInterviews() {

        return ResponseEntity.ok(
                interviewService.getAllInterviews()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewResponse> getInterviewById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                interviewService.getInterviewById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateInterview(
            @PathVariable Integer id,
            @RequestBody InterviewRequest request) {

        return ResponseEntity.ok(
                interviewService.updateInterview(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInterview(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                interviewService.deleteInterview(id)
        );
    }

}