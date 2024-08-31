package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.ResultStudentExam;
import com.project.azmoon.domain.Student;

public interface ResultStudentExamService extends BaseEntityService<ResultStudentExam,Long> {
    ResultStudentExam findByStudent(Student student);
}
