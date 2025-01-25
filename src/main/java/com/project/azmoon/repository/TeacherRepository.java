package com.project.azmoon.repository;


import com.project.azmoon.domain.Teacher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends UserRepository<Teacher> {

    @Override
    List<Teacher> findAll(Specification<Teacher> spec);

    Boolean existsByTeacherCode(String personnelCode);

    List<Teacher> findByIsActiveFalse();

    List<Teacher> findByIsActiveTrue();

    Teacher findByTeacherCode(String teacherCode);
}
