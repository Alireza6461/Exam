package com.project.azmoon.service;

import com.project.azmoon.domain.Student;

import java.util.List;

public interface StudentService extends UserService<Student>{
    List<Student> findByIsActiveFalse();

    List<Student> findByIsActiveTrue();
}
