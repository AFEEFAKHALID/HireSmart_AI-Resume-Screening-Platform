package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateResponse {

    private Integer candidateId;

    private Integer userId;

    private String currentJobTitle;

    private String message;

}