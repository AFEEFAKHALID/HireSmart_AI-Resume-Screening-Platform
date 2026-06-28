package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.RecruiterRequest;
import com.hiresmart.server.dto.response.RecruiterResponse;
import com.hiresmart.server.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RecruiterController {

    private final RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<String> createRecruiter(
            @RequestBody RecruiterRequest request) {

        return ResponseEntity.ok(
                recruiterService.createRecruiter(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<RecruiterResponse>> getAllRecruiters() {

        return ResponseEntity.ok(
                recruiterService.getAllRecruiters()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruiterResponse> getRecruiterById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                recruiterService.getRecruiterById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRecruiter(
            @PathVariable Integer id,
            @RequestBody RecruiterRequest request) {

        return ResponseEntity.ok(
                recruiterService.updateRecruiter(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecruiter(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                recruiterService.deleteRecruiter(id)
        );
    }

}