package com.quinbay.Springapp.service;

import com.quinbay.Springapp.dto.Department;
import com.quinbay.Springapp.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    List<Department> getAlldeptinfo();


    void addEmployee(Department dpt);

    Department UpdateEmp(Department dpt);
    void deleteEmployee(Department dptt);
}
