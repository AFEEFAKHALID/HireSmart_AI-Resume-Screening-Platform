package com.hiresmart.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIAnalysisRequest {

    /**
     * Resume uploaded by the candidate
     */
    private Integer resumeId;

    /**
     * Job against which the resume will be analyzed
     */
    private Integer jobId;

}