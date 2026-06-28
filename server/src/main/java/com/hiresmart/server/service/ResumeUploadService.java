package com.hiresmart.server.service;

import com.hiresmart.server.dto.response.UploadResponse;
import com.hiresmart.server.entity.Candidate;
import com.hiresmart.server.entity.Resume;
import com.hiresmart.server.enums.FileType;
import com.hiresmart.server.repository.CandidateRepository;
import com.hiresmart.server.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResumeUploadService {

    private final ResumeRepository resumeRepository;
    private final CandidateRepository candidateRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public UploadResponse uploadResume(Integer candidateId,
                                       MultipartFile file,
                                       String title) throws IOException {

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        File directory = new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String originalName = file.getOriginalFilename();

        String extension = originalName.substring(originalName.lastIndexOf(".") + 1);

        String storedName = UUID.randomUUID() + "." + extension;

        File destination = new File(directory, storedName);

        file.transferTo(destination);

        Resume resume = Resume.builder()
                .candidate(candidate)
                .resumeTitle(title)
                .originalFileName(originalName)
                .storedFileName(storedName)
                .filePath(destination.getAbsolutePath())
                .fileSize(file.getSize())
                .fileType(FileType.valueOf(extension.toUpperCase()))
                .isDefault(true)
                .build();

        resumeRepository.save(resume);

        return UploadResponse.builder()
                .resumeId(resume.getResumeId())
                .fileName(originalName)
                .filePath(destination.getAbsolutePath())
                .message("Resume uploaded successfully")
                .build();
    }
}