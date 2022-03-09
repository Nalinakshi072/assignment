package com.quinbay.Springapp.service;

import com.quinbay.Springapp.dto.Department;
import com.quinbay.Springapp.dto.Student;
import com.quinbay.Springapp.entity.StudentEntity;
import com.quinbay.Springapp.entity.StudentMongoEntity;
import com.quinbay.Springapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class Studentserviceimpl implements Studentservice {

    @Autowired
    Studentdb studentdb;

    @Autowired
    Departmentdb departmentdb;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;


    @Autowired
    StudentMongoRepository studentMongoRepository;

    boolean flag_redis;
    boolean flag_mongo;
    boolean flag_post;

    @Override
    @GetMapping("/getAllstudents")
    public List<Student> getAllstudents() {

        Iterable<StudentMongoEntity> std = studentMongoRepository.findAll();
        List<Student> stdCombined = new ArrayList<>();
        for (StudentMongoEntity item : std) {
            stdCombined.add(new Student(item.getId(), item.getfName()));
        }

        stdCombined.addAll(new ArrayList<>(studentRedisRepository.findAll()));

        Iterable<StudentEntity> iterator = studentRepository.findAll();
        for (StudentEntity i : iterator) {
            stdCombined.add(new Student(i.getId(), i.getName()));
        }
        return stdCombined;
    }


    // @Override

//    public Student getStudent(Integer id) {
//        for (Student s : studentdb.getStudentList()) {
//            if (s.getId() == id) {
//                studentdb.list.set(1,"nalina");
//
//
//
//                for (Department d : departmentdb.getDepartmentList()) {
//                    if (s.getDept_id() == d.getDpt_id()) {
//                   //     return d;
//                    }
//                }
//                return null;
//            }
//            return null;
//        }
//        return null;
//    }


    @Override
    public void addStudent(String database, Student student) {
        if (database.equals("mongo")) {
            studentMongoRepository.save(new StudentMongoEntity(student.getId(), student.getF_name()));
        }

        if (database.equals("redis")) {
            //studentMongoRepository.save(new StudentMongoEntity(student.getId(), student.getF_name()));
            studentRedisRepository.save(student);
        } else if (database.equals("postgresql")) {

            studentRepository.save(new StudentEntity(student.getF_name()));
        } else if (database.equals("list")) {
            studentdb.list.add(new Student(student.getId(), student.getF_name()));
            studentdb.add2(student);
        }
    }

    @Override
    public Student Updatestudent( Student student) {

        List<Student> std_redis = new ArrayList<>();
        std_redis.addAll(studentRedisRepository.findAll());

//    Optional<StudentEntity> iterator = studentRepository.findById(student.getId());
//    if(iterator.isPresent()){
//       StudentEntity s= iterator.get();
//    }

//    Student student1 = new Student();
        //udent1.setF_name(iterator.);

        List<Student> student_post = new ArrayList<>();
        Iterable<StudentEntity> iterator = studentRepository.findAll();
        for (StudentEntity i : iterator) {
            Student student1 = new Student();
            student1.setId(i.getId());
            student1.setF_name(i.getName());
            student_post.add(student);
        }

        Iterable<StudentMongoEntity> std = studentMongoRepository.findAll();
        List<Student> std_mongo = new ArrayList<>();
        for (StudentMongoEntity item : std) {
            Student student2 = new Student(item.getId(), item.getfName());
            std_mongo.add(student2);
        }

        flag_redis = (std_redis.contains(student)) ? true : false;
        flag_mongo = (std_mongo.contains(student)) ? true : false;
        flag_post = (student_post.contains(student)) ? true : false;

        if (flag_mongo) {


            studentMongoRepository.save(new StudentMongoEntity(student.getId(), student.getF_name()));
            return student;
        } else if (flag_post) {

            //Iterable<StudentEntity> iterator = studentRepository.findById();
            //for (StudentEntity i : iterator) {
            // if (student.getId() == i.getId()) {

            studentRepository.save(new StudentEntity(student.getId(), student.getF_name()));
            return student;
        } else if (flag_redis) {

            studentRedisRepository.save(student);
            return student;

        }
        return null;
    }

    //   break;
    //}

    //}
    //return student;


//        for(Student s: studentdb.list){
//            if(id==s.getId()){
//                s.setId(student.getId());
//                s.setF_name(student.getF_name());
//
//              s.setL_name(student.getL_name());
//              s.setBranch(student.getBranch());
//
//            }
//        }


    public void deleteStudent(Student std) {


        boolean isRedis = false, isPostgres = false, isListDb = false, isMongo = false;

        List<Student> student1 = studentdb.getStudentList();
        List<Student> redisStudent = studentRedisRepository.findAll();
        Iterable<StudentMongoEntity> mongoStudent = studentMongoRepository.findAll();
        Iterable<StudentEntity> iterator = studentRepository.findAll();
        List<Student> studentEntities = new ArrayList<>();
        List<Student> studentsMongo = new ArrayList<>();
        for (StudentEntity i : iterator) {
            Student student = new Student();
            student.setId(i.getId());
            student.setF_name(i.getName());
            studentEntities.add(student);
        }
        for (StudentMongoEntity i : mongoStudent) {
            Student student = new Student();
            student.setId(i.getId());
            student.setF_name(i.getfName());
            studentsMongo.add(student);
        }


        for (Student s : student1) {
            if (s.getId() == std.getId()) {
                isListDb = true;
                break;
            }
        }

        for (Student s : studentEntities) {
            if (s.getId() == std.getId()) {
                isPostgres = true;
                break;
            }
        }

        for (Student s : redisStudent) {
            if (s.getId() == std.getId()) {
                isRedis = true;
                break;
            }
        }
        for (Student s : studentsMongo) {
            if (s.getId() == std.getId()) {
                isMongo = true;
            }
        }

        if (isListDb) {

            studentdb.deleteStudent(std.getId());

        } else if (isPostgres) {
            studentRepository.delete(new StudentEntity(std.getId(), std.getF_name()));


        } else if (isRedis) {
            studentRedisRepository.delete(std.getId());

        } else if (isMongo) {
            studentMongoRepository.delete(new StudentMongoEntity(std.getId(), std.getF_name()));
        }


        //List<Student> student_post = new ArrayList<>();
//              Iterable<StudentEntity> iterator = studentRepository.findAll();
//        Iterable<StudentMongoEntity> studentEntityIterator = studentMongoRepository.findAll();
//        for(StudentMongoEntity mongoEntity:studentEntityIterator)
//            if(mongoEntity.getId().equals(std.getId())) {
//                studentMongoRepository.delete(mongoEntity);
//            }

    }


//        for (Student s : studentdb.list) {
//            if (std.getId() == s.getId()) {
//                studentdb.list.remove(s);
//
//            }
//
//        }


}




