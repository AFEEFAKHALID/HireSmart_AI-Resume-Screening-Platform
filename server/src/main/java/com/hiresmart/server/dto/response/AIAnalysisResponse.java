package com.hiresmart.server.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIAnalysisResponse {

    private Integer analysisId;

    private Integer atsScore;

    private Integer matchedSkills;

    private Integer missingSkills;

    private Integer matchedKeywords;

    private List<String> recommendations;

    private String summary;

}