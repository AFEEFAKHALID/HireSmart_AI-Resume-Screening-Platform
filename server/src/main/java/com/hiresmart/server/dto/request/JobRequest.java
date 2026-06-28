package com.hiresmart.server.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobRequest {

    private Integer recruiterId;
    private Integer companyId;
    private Integer categoryId;

    private String jobTitle;
    private String jobDescription;
    private String responsibilities;
    private String qualifications;

    private BigDecimal experienceRequired;
    private BigDecimal salaryMin;
    private BigDecimal salaryMax;

    private String employmentType;
    private String workplaceType;

    private String country;
    private String state;
    private String city;

    private Integer vacancies;

    private LocalDate applicationDeadline;

}