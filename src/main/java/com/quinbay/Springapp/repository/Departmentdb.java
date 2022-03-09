package com.quinbay.Springapp.repository;

import com.quinbay.Springapp.dto.Department;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

@Repository
public class Departmentdb {

    public static ArrayList<Department> dept_list = new ArrayList<>();

    public static ArrayList<Department> getDepartmentList() {
        dept_list.add(new Department(101, "emp1", "manger"));
        dept_list.add(new Department(102, "e2", "d2"));
        dept_list.add(new Department(103, "e3", "d3"));
        return dept_list;
    }

    public void add2(Department d) {
        dept_list.add(d);
    }

}
