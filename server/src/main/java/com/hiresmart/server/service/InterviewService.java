package com.hiresmart.server.service;

import com.hiresmart.server.dto.request.InterviewRequest;
import com.hiresmart.server.dto.response.InterviewResponse;
import com.hiresmart.server.entity.Application;
import com.hiresmart.server.entity.Interview;
import com.hiresmart.server.entity.Recruiter;
import com.hiresmart.server.enums.InterviewStatus;
import com.hiresmart.server.enums.InterviewType;
import com.hiresmart.server.repository.ApplicationRepository;
import com.hiresmart.server.repository.InterviewRepository;
import com.hiresmart.server.repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final ApplicationRepository applicationRepository;
    private final RecruiterRepository recruiterRepository;

    public String scheduleInterview(InterviewRequest request) {

        Application application = applicationRepository.findById(request.getApplicationId())
                .orElseThrow(() -> new RuntimeException("Application not found"));

        Recruiter recruiter = recruiterRepository.findById(request.getRecruiterId())
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        Interview interview = Interview.builder()
                .application(application)
                .recruiter(recruiter)
                .interviewType(InterviewType.valueOf(request.getInterviewType()))
                .interviewRound(request.getInterviewRound())
                .interviewDate(request.getInterviewDate())
                .durationMinutes(request.getDurationMinutes())
                .meetingLink(request.getMeetingLink())
                .interviewLocation(request.getInterviewLocation())
                .interviewStatus(InterviewStatus.SCHEDULED)
                .createdAt(LocalDateTime.now())
                .build();

        interviewRepository.save(interview);

        return "Interview scheduled successfully";
    }

    public List<InterviewResponse> getAllInterviews() {

        return interviewRepository.findAll()
                .stream()
                .map(interview -> InterviewResponse.builder()
                        .interviewId(interview.getInterviewId())
                        .applicationId(interview.getApplication().getApplicationId())
                        .recruiterId(interview.getRecruiter().getRecruiterId())
                        .interviewType(interview.getInterviewType().name())
                        .interviewRound(interview.getInterviewRound())
                        .interviewStatus(interview.getInterviewStatus().name())
                        .message("Success")
                        .build())
                .collect(Collectors.toList());
    }

    public InterviewResponse getInterviewById(Integer id) {

        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        return InterviewResponse.builder()
                .interviewId(interview.getInterviewId())
                .applicationId(interview.getApplication().getApplicationId())
                .recruiterId(interview.getRecruiter().getRecruiterId())
                .interviewType(interview.getInterviewType().name())
                .interviewRound(interview.getInterviewRound())
                .interviewStatus(interview.getInterviewStatus().name())
                .message("Success")
                .build();
    }

    public String updateInterview(Integer id, InterviewRequest request) {

        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        interview.setInterviewType(InterviewType.valueOf(request.getInterviewType()));
        interview.setInterviewRound(request.getInterviewRound());
        interview.setInterviewDate(request.getInterviewDate());
        interview.setDurationMinutes(request.getDurationMinutes());
        interview.setMeetingLink(request.getMeetingLink());
        interview.setInterviewLocation(request.getInterviewLocation());

        interviewRepository.save(interview);

        return "Interview updated successfully";
    }

    public String deleteInterview(Integer id) {

        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        interviewRepository.delete(interview);

        return "Interview deleted successfully";
    }

}