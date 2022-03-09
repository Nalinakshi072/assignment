package com.quinbay.Springapp.entity;




import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Document(collection = "Student")
public class StudentMongoEntity {
    @Id
    private Long id;


    public StudentMongoEntity() {
    }

    private String fName;

    private String lName;
    private String branch;
    private int dept_id;
    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getBranch() {
        return branch;
    }


    public void setBranch(String branch) {
        this.branch = branch;
    }

    public StudentMongoEntity(Long id,String fName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.branch = branch;
        this.dept_id = dept_id;
    }
}

