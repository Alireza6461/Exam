package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.Exam;
import com.project.azmoon.domain.ResultStudentExam;
import com.project.azmoon.domain.Student;

import java.util.List;

public interface ResultStudentExamService extends BaseEntityService<ResultStudentExam,Long> {
    List<ResultStudentExam> findByStudent(Student student);
    ResultStudentExam findByStudentAndExam(Student student, Exam exam);
}
