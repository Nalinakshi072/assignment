package com.quinbay.Springapp.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Student implements Serializable {


        private Long id;

        @NotBlank(message = "student name cannot be empty")
        private String f_name;


        private String l_name;
        private String branch;



        private int dept_id;
        public Student(){}
        public Student(Long id, String fname){// String lname, String branch,int dept_id){
            this.id=id;
            this.f_name=fname;
           // this.l_name=lname;
            //this.branch=branch;
            //this.dept_id=dept_id;
        }
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getF_name() {
            return f_name;
        }

        public void setF_name(String f_name) {
            this.f_name = f_name;
        }

        public String getL_name() {
            return l_name;
        }

        public void setL_name(String l_name) {
            this.l_name = l_name;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public int getDept_id() {
            return dept_id;
        }

        public void setDept_id(int dept_id) {
            this.dept_id = dept_id;
        }



    }


