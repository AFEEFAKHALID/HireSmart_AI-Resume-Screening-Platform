package com.hiresmart.server.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private String message;

}