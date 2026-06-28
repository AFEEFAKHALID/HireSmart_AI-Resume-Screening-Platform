package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationResponse {

    private Integer applicationId;

    private Integer candidateId;

    private Integer jobId;

    private Integer resumeId;

    private String applicationStatus;

    private String message;

}