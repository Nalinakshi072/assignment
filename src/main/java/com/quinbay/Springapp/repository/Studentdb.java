package com.quinbay.Springapp.repository;


import com.quinbay.Springapp.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class Studentdb {

    public static ArrayList<Student> list=new ArrayList<>();
    public static ArrayList<Student> getStudentList(){
        list.add(new Student(1L,"a"));
        list.add(new Student(2L,"b"));
        list.add(new Student(3L,"c"));
        return list;
    }

    public void add2(Student s){


        list.add(s);
    }
    public void deleteStudent(Long i){
//        llist.remove(llist.get(i));
        for(Student student : list){
            if(student.getId() == i){
                list.remove(student);
                break;
            }
        }
    }



}
