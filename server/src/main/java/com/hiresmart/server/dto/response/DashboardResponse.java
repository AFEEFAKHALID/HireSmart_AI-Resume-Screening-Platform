package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardResponse {

    private Long totalCandidates;

    private Long totalCompanies;

    private Long totalRecruiters;

    private Long totalJobs;

    private Long totalApplications;

    private Long totalInterviews;

    private Long totalResumes;

}