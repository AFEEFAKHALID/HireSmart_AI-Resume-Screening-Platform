package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruiterResponse {

    private Integer recruiterId;
    private Integer userId;
    private Integer companyId;
    private String designation;
    private String department;
    private String recruiterType;
    private String message;

}