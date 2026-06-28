package com.hiresmart.server.controller;

import com.hiresmart.server.dto.response.UploadResponse;
import com.hiresmart.server.service.ResumeUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ResumeUploadController {

    private final ResumeUploadService resumeUploadService;

    @PostMapping("/resume")
    public ResponseEntity<UploadResponse> uploadResume(

            @RequestParam Integer candidateId,

            @RequestParam String title,

            @RequestParam MultipartFile file

    ) throws Exception {

        return ResponseEntity.ok(

                resumeUploadService.uploadResume(candidateId, file, title)

        );

    }

}