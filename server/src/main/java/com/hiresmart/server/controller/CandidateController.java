package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.CandidateRequest;
import com.hiresmart.server.dto.response.CandidateResponse;
import com.hiresmart.server.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    public ResponseEntity<String> createCandidate(
            @RequestBody CandidateRequest request) {

        return ResponseEntity.ok(
                candidateService.createCandidate(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getAllCandidates() {

        return ResponseEntity.ok(
                candidateService.getAllCandidates()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> getCandidateById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                candidateService.getCandidateById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCandidate(
            @PathVariable Integer id,
            @RequestBody CandidateRequest request) {

        return ResponseEntity.ok(
                candidateService.updateCandidate(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCandidate(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                candidateService.deleteCandidate(id)
        );
    }

}