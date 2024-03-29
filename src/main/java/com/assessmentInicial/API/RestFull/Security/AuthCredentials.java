package com.assessmentInicial.API.RestFull.Security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
