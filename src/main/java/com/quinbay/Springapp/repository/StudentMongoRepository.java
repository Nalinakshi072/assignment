package com.quinbay.Springapp.repository;
import com.quinbay.Springapp.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoRepository extends CrudRepository<StudentMongoEntity,Long> {
}
