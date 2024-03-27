package com.cap.college_admission_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.college_admission_portal.model.*;

public interface AdmissionRepo extends JpaRepository<Admission,Integer> {
    
}
