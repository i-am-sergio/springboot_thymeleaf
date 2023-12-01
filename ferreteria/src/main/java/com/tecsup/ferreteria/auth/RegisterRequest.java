package com.tecsup.ferreteria.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty
    @Email(message = "Email should be valid")
    private String username; // email

    @NotNull
    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;

    @NotNull
    @Size(min = 3, message = "First name must be at least 3 characters long")
    private String firstname;

    @NotNull
    @Size(min = 3, message = "Last name must be at least 3 characters long")
    private String lastname;
}
