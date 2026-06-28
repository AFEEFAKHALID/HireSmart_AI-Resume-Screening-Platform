package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeResponse {

    private Integer resumeId;

    private Integer candidateId;

    private String resumeTitle;

    private String originalFileName;

    private String fileType;

    private Long fileSize;

    private String message;

}