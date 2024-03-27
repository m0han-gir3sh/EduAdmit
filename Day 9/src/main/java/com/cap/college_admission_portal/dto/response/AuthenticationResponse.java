package com.cap.college_admission_portal.dto.response;

import com.cap.college_admission_portal.model.enumerate.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private Long uid;
    private String name;
    private Role role;
    private String email;
    private String admin;
}
