package com.tecsup.ferreteria.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tecsup.ferreteria.jwt.JwtService;
import com.tecsup.ferreteria.users.Role;
import com.tecsup.ferreteria.users.UserModel;
import com.tecsup.ferreteria.users.UserRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthUserResponse login(@Valid LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(userDetails);
        return AuthUserResponse.from((UserModel) userDetails, token);
    }   
    public AuthUserResponse register(@Valid RegisterRequest request){
        UserModel user = UserModel.builder()
                            .username(request.getUsername())
                            .password(passwordEncoder.encode( request.getPassword() ))
                            .firstname(request.getFirstname())
                            .lastname(request.getLastname())
                            .role(Role.USER)
                            .build();
        
        userRepository.save(user);
        return AuthUserResponse.from(user, jwtService.getToken(user));
    }
}
