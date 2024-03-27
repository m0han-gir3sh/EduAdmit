package com.cap.college_admission_portal.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.college_admission_portal.model.Studentdetail;


public interface StudentdetailRepo extends JpaRepository<Studentdetail,String> {
    Studentdetail findBySdid(String sdid);
}
