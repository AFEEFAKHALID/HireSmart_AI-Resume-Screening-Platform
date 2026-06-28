package com.hiresmart.server.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruiterRequest {

    private Integer userId;
    private Integer companyId;
    private String designation;
    private String department;
    private String recruiterType;
    private Boolean isPrimary;

}