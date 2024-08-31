package com.project.azmoon.repository;

import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long>, JpaSpecificationExecutor<Course> {

    List<Course> findByTeacher(Teacher teacher);
}
