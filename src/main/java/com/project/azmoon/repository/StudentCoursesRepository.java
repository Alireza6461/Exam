package com.project.azmoon.repository;

import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Student;
import com.project.azmoon.domain.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses,Long> , JpaSpecificationExecutor<StudentCourses> {

    List<StudentCourses> findByCourse(Course course);

    List<StudentCourses> findByStudent(Student student);
}
