package com.quinbay.Springapp.service;

import com.quinbay.Springapp.dto.Department;
import com.quinbay.Springapp.dto.Student;
import com.quinbay.Springapp.repository.Departmentdb;
import com.quinbay.Springapp.repository.Studentdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService {

    @Autowired
    Departmentdb deptdb;
    @Override


    @GetMapping("/getAlldeptinfo")

    public List<Department> getAlldeptinfo(){

        return deptdb.getDepartmentList();
    }


    @Override

    public void addEmployee(Department dpt)
    {

        deptdb.add2(dpt);
    }

    @Override
    public Department UpdateEmp(Department dpt){

        int id = dpt.getDpt_id();

        for(Department d: deptdb.dept_list){
            if(id==d.getDpt_id()){
                d.setDpt_id(dpt.getDpt_id());
                d.setD_name(dpt.getD_name());
                d.setDesig(dpt.getDesig());
                //return d;
            }
        }

        return  null;
    }


    public void deleteEmployee(Department dpt) {
        for (Department d : deptdb.dept_list) {
            if (dpt.getDpt_id() == d.getDpt_id()) {
                deptdb.dept_list.remove(d);

            }

        }


    }

}
