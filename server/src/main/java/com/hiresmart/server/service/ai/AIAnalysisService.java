package com.hiresmart.server.service.ai;

import com.hiresmart.server.dto.request.AIAnalysisRequest;
import com.hiresmart.server.dto.response.AIAnalysisResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AIAnalysisService {

    public AIAnalysisResponse analyzeResume(AIAnalysisRequest request) {

        int atsScore = 82;

        return AIAnalysisResponse.builder()
                .analysisId(1)
                .atsScore(atsScore)
                .matchedSkills(8)
                .missingSkills(2)
                .matchedKeywords(15)
                .summary("Resume is a good match for the selected job.")
                .recommendations(Arrays.asList(
                        "Add Docker experience",
                        "Mention REST APIs",
                        "Improve project descriptions"
                ))
                .build();
    }
}