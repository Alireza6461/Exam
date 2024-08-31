package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Teacher;

import java.util.List;

public interface CourseService extends BaseEntityService<Course,Long> {

    List<Course> findByTeacher(Teacher teacher);
}
