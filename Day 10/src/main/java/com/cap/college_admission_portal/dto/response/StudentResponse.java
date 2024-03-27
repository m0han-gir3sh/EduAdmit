package com.cap.college_admission_portal.dto.response;

import java.util.Date;

import com.cap.college_admission_portal.model.enumerate.Role;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class StudentResponse {
    private Long sid;
    private String firstName;
    private String lastname;
    private String dateofbirth;
    // private String email;
    private String phonenumber;
    private String address;
    private String citizen;
    private String high_school;
    private Role role;
   
    
}
