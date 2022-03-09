package com.quinbay.Springapp.controller;


import com.quinbay.Springapp.dto.Student;
import com.quinbay.Springapp.repository.Studentdb;
import com.quinbay.Springapp.service.DepartmentService;
import com.quinbay.Springapp.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/s")
@RestController
public class basecontrol {


    @Autowired
    Studentservice Stservice;





    @GetMapping("/getAllstudents")

    public List<Student> getAllstudents() {
        return Stservice.getAllstudents();

    }

//    @GetMapping(value = "/{id}",produces = "application/json")
//    public Student getall(@PathVariable Integer id){
//        return Stservice.getStudent(id);
//    }


    //  @GetMapping(produces = "application/json")
    //public Object getall(@RequestParam(required = true) Integer id, String f_name) {
    // return Stservice.getStudent(id);
    //  }

    @PostMapping(produces = "application/json")
    public void addStudent(@RequestParam String database, @RequestBody @Valid Student student) {
        Stservice.addStudent(database, student);
    }

    @PutMapping(produces = "application/json")
    public void UpdateStudent( @RequestBody @Valid Student student) {
        Stservice.Updatestudent( student);
    }

    @DeleteMapping(produces = "application/json")
    public void deleteStudent(@RequestBody Student student) {
        Stservice.deleteStudent(student);
    }
}


