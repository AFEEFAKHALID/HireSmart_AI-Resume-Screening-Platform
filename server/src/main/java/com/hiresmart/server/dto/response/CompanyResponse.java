package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponse {

    private Integer companyId;
    private String companyName;
    private String companyEmail;
    private String companyPhone;
    private String industry;
    private String city;
    private String country;
    private String message;

}