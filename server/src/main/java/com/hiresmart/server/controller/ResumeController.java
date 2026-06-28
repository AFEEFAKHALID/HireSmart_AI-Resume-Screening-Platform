package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.ResumeRequest;
import com.hiresmart.server.dto.response.ResumeResponse;
import com.hiresmart.server.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping
    public ResponseEntity<String> createResume(
            @RequestBody ResumeRequest request) {

        return ResponseEntity.ok(
                resumeService.createResume(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<ResumeResponse>> getAllResumes() {

        return ResponseEntity.ok(
                resumeService.getAllResumes()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResumeResponse> getResumeById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                resumeService.getResumeById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateResume(
            @PathVariable Integer id,
            @RequestBody ResumeRequest request) {

        return ResponseEntity.ok(
                resumeService.updateResume(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResume(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                resumeService.deleteResume(id)
        );
    }

}