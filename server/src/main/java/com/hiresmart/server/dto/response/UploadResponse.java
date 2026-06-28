package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadResponse {

    private Integer resumeId;
    private String fileName;
    private String filePath;
    private String message;

}