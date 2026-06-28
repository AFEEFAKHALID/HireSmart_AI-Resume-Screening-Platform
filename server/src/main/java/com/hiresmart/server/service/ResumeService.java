package com.hiresmart.server.service;

import com.hiresmart.server.dto.request.ResumeRequest;
import com.hiresmart.server.dto.response.ResumeResponse;
import com.hiresmart.server.entity.Candidate;
import com.hiresmart.server.entity.Resume;
import com.hiresmart.server.enums.FileType;
import com.hiresmart.server.repository.CandidateRepository;
import com.hiresmart.server.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final CandidateRepository candidateRepository;

    public String createResume(ResumeRequest request) {

        Candidate candidate = candidateRepository.findById(request.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Resume resume = Resume.builder()
                .candidate(candidate)
                .resumeTitle(request.getResumeTitle())
                .originalFileName(request.getOriginalFileName())
                .storedFileName(request.getStoredFileName())
                .filePath(request.getFilePath())
                .fileType(FileType.valueOf(request.getFileType()))
                .fileSize(request.getFileSize())
                .isDefault(request.getIsDefault())
                .build();

        resumeRepository.save(resume);

        return "Resume uploaded successfully";
    }

    public List<ResumeResponse> getAllResumes() {

        return resumeRepository.findAll()
                .stream()
                .map(resume -> ResumeResponse.builder()
                        .resumeId(resume.getResumeId())
                        .candidateId(resume.getCandidate().getCandidateId())
                        .resumeTitle(resume.getResumeTitle())
                        .originalFileName(resume.getOriginalFileName())
                        .fileType(resume.getFileType().name())
                        .fileSize(resume.getFileSize())
                        .message("Success")
                        .build())
                .collect(Collectors.toList());
    }

    public ResumeResponse getResumeById(Integer id) {

        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        return ResumeResponse.builder()
                .resumeId(resume.getResumeId())
                .candidateId(resume.getCandidate().getCandidateId())
                .resumeTitle(resume.getResumeTitle())
                .originalFileName(resume.getOriginalFileName())
                .fileType(resume.getFileType().name())
                .fileSize(resume.getFileSize())
                .message("Success")
                .build();
    }

    public String updateResume(Integer id, ResumeRequest request) {

        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        resume.setResumeTitle(request.getResumeTitle());
        resume.setOriginalFileName(request.getOriginalFileName());
        resume.setStoredFileName(request.getStoredFileName());
        resume.setFilePath(request.getFilePath());
        resume.setFileType(FileType.valueOf(request.getFileType()));
        resume.setFileSize(request.getFileSize());
        resume.setIsDefault(request.getIsDefault());

        resumeRepository.save(resume);

        return "Resume updated successfully";
    }

    public String deleteResume(Integer id) {

        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        resumeRepository.delete(resume);

        return "Resume deleted successfully";
    }

}