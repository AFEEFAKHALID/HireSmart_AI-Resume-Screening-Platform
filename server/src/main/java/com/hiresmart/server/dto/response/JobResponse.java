package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobResponse {

    private Integer jobId;

    private String jobTitle;

    private String companyName;

    private String recruiterName;

    private String status;

    private String message;

}