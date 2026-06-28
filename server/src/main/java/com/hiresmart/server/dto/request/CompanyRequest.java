package com.hiresmart.server.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRequest {

    private String companyName;
    private String companyEmail;
    private String companyPhone;
    private String website;
    private String industry;
    private String companySize;
    private Integer foundedYear;
    private String country;
    private String state;
    private String city;
    private String address;
    private String logo;
    private String description;

}