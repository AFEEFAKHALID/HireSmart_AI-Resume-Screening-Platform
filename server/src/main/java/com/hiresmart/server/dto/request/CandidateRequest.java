package com.hiresmart.server.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateRequest {

    private Integer userId;

    private String currentJobTitle;

    private BigDecimal totalExperience;

    private BigDecimal expectedSalary;

    private BigDecimal currentSalary;

    private Integer noticePeriod;

    private Boolean willingToRelocate;

    private Boolean openToRemote;

    private String linkedinUrl;

    private String githubUrl;

    private String portfolioUrl;

}