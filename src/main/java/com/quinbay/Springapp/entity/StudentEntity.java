package com.quinbay.Springapp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Student")
public class StudentEntity {
    public StudentEntity(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;
    @NotBlank(message = "Student name cant be empty")
    private String Name;

    public StudentEntity( String Name){

        this.Name=Name;
    }

    public StudentEntity(Long id, String Name){
    this.id=id;
        this.Name=Name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
