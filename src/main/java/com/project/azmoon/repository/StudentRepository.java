package com.project.azmoon.repository;


import com.project.azmoon.domain.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends UserRepository<Student> {

    @Override
    List<Student> findAll(Specification<Student> spec);

    Boolean existsByStudentCode(String studentCode);


    List<Student> findByIsActiveFalse();

    List<Student> findByIsActiveTrue();

}
