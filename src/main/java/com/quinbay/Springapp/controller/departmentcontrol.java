package com.quinbay.Springapp.controller;

import com.quinbay.Springapp.dto.Department;

import com.quinbay.Springapp.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/d")
@RestController
public class departmentcontrol {


    @Autowired
    DepartmentService Dtservice;


    @GetMapping("/getAlldeptinfo")

    public List<Department> getAlldeptinfo() {
        return Dtservice.getAlldeptinfo();
    }



    @PostMapping(produces = "application/json")
    public void addEmployee(@RequestBody Department dpt) {
        Dtservice.addEmployee(dpt);
    }

    @PutMapping(produces = "application/json")
    public void UpdateEmp(@RequestBody Department dpt) {
        Dtservice.UpdateEmp(dpt);
    }

    @DeleteMapping(produces = "application/json")
    public void deleteEmployee(@RequestBody Department dpt) {
        Dtservice.deleteEmployee(dpt);
    }

}
