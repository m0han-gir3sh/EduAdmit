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
public class StudentdetailResponse {
    private String firstName;
    private String lastName;
    private String dateofbirth;
    private String phonenumber;
    private String nationality;
    private String state;
    private String caste;
    private Role role;
}
