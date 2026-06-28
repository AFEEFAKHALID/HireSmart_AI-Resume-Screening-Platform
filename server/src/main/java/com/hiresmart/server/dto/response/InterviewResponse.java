package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewResponse {

    private Integer interviewId;

    private Integer applicationId;

    private Integer recruiterId;

    private String interviewType;

    private String interviewRound;

    private String interviewStatus;

    private String message;

}