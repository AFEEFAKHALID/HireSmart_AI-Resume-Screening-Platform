package com.hiresmart.server.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationRequest {

    private Integer candidateId;

    private Integer jobId;

    private Integer resumeId;

    private String coverLetter;

    private String notes;

}