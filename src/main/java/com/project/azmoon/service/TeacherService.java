package com.project.azmoon.service;

import com.project.azmoon.domain.Teacher;
import com.project.azmoon.service.UserService;

import java.util.List;

public interface TeacherService extends UserService<Teacher> {

    List<Teacher> findByIsActiveFalse();
    List<Teacher> findByIsActiveTrue();

    Teacher findByTeacherCode(String teacherCode);

}
