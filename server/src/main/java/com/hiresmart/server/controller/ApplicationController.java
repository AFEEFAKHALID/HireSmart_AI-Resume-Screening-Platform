package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.ApplicationRequest;
import com.hiresmart.server.dto.response.ApplicationResponse;
import com.hiresmart.server.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<String> applyJob(
            @RequestBody ApplicationRequest request) {

        return ResponseEntity.ok(
                applicationService.applyJob(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<ApplicationResponse>> getAllApplications() {

        return ResponseEntity.ok(
                applicationService.getAllApplications()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponse> getApplicationById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                applicationService.getApplicationById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateApplication(
            @PathVariable Integer id,
            @RequestBody ApplicationRequest request) {

        return ResponseEntity.ok(
                applicationService.updateApplication(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                applicationService.deleteApplication(id)
        );
    }
}