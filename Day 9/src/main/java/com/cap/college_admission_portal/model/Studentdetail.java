package com.cap.college_admission_portal.model;

import org.springframework.data.annotation.CreatedDate;

import com.cap.college_admission_portal.model.enumerate.Role;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="studentinformations")
public class Studentdetail  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
      private String sdid;
      private String firstName;
      private String lastName;
      private String dateofbirth;
    
      private String phonenumber;
     
      private String nationality;
      private String email;
      private String gender;
    
      private String state;
    
      private String caste;
      @Enumerated(EnumType.STRING)
      private Role role;
      @CreatedDate
      @Temporal(TemporalType.TIMESTAMP)
      private Date createdOn;

}
