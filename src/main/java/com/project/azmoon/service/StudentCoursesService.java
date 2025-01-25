package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Student;
import com.project.azmoon.domain.StudentCourses;

import java.util.List;

public interface StudentCoursesService extends BaseEntityService<StudentCourses,Long> {
    List<StudentCourses> findByCourse(Course course);

    List<StudentCourses> findByStudent(Student student);
}
