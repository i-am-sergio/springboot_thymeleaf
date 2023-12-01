package com.tecsup.ferreteria.auth;

import java.util.List;

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
    private boolean isAdmin;
    private String profilePicture;
    private String coverPicture;
    private String about;
    private String livesIn;
    private String worksAt;
    private String relationship;
    private String country;
    private Role role;
    private List<Long> followers;
    private List<Long> following;

    public static AuthUserResponse from(UserModel user, String token) {
        return AuthUserResponse.builder()
                .token(token)
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .isAdmin(user.isAdmin())
                .profilePicture(user.getProfilePicture())
                .coverPicture(user.getCoverPicture())
                .about(user.getAbout())
                .livesIn(user.getLivesIn())
                .worksAt(user.getWorksAt())
                .relationship(user.getRelationship())
                .country(user.getCountry())
                .role(user.getRole())
                .followers(user.getFollowers())
                .following(user.getFollowing())
                .build();
    }
}

