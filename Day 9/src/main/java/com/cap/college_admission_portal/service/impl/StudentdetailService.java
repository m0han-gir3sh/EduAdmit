package com.cap.college_admission_portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.college_admission_portal.dto.request.StudentRequest;
import com.cap.college_admission_portal.dto.response.StudentdetailResponse;
import com.cap.college_admission_portal.model.Studentdetail;
import com.cap.college_admission_portal.model.enumerate.Role;
import com.cap.college_admission_portal.repository.StudentdetailRepo;

import java.util.Optional;
import java.util.List;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
public class StudentdetailService {
    @Autowired
    private  StudentdetailRepo studentdetailRepo;


    public List<Studentdetail> getAllStudents() {
         return studentdetailRepo.findAll();
    }
    public Studentdetail postStudent(Studentdetail student) {

          return studentdetailRepo.save(student);   
        
    }
    public boolean deleteStudent(String sdid) {

        studentdetailRepo.deleteById(sdid);
        return true;
         
    }
    
}
