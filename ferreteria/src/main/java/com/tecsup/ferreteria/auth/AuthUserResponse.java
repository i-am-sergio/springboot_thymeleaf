package com.tecsup.ferreteria.auth;

import com.tecsup.ferreteria.users.Role;
import com.tecsup.ferreteria.users.UserModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserResponse {
    private String token;
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private Role role;

    public static AuthUserResponse from(UserModel user, String token) {
        return AuthUserResponse.builder()
                .token(token)
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .role(user.getRole())
                .build();
    }
}

