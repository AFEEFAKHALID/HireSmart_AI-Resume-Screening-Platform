package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.AIAnalysisRequest;
import com.hiresmart.server.dto.response.AIAnalysisResponse;
import com.hiresmart.server.service.ai.AIAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AIController {

    private final AIAnalysisService aiAnalysisService;

    @PostMapping("/analyze")
    public ResponseEntity<AIAnalysisResponse> analyzeResume(
            @RequestBody AIAnalysisRequest request) {

        return ResponseEntity.ok(
                aiAnalysisService.analyzeResume(request)
        );
    }
}