package com.quinbay.Springapp.repository;

import com.quinbay.Springapp.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Long> {

}
