package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Exam;

import java.util.List;

public interface ExamService extends BaseEntityService<Exam,Long> {

    List<Exam> findByCourse(Course course);
}
