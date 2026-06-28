package com.hiresmart.server.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeRequest {

    private Integer candidateId;

    private String resumeTitle;

    private String originalFileName;

    private String storedFileName;

    private String filePath;

    private String fileType;

    private Long fileSize;

    private Boolean isDefault;

}