package com.quinbay.Springapp.service;

import com.quinbay.Springapp.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Studentservice {

    List<Student> getAllstudents();
    // Object getStudent(Integer s1);

    void addStudent(String database, Student student);

    Student Updatestudent( Student student);

    void deleteStudent(Student student);

}
