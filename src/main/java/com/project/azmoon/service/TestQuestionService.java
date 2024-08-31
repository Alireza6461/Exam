package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.Teacher;
import com.project.azmoon.domain.TestQuestion;

import java.util.List;

public interface TestQuestionService extends BaseEntityService<TestQuestion,Long> {
    List<TestQuestion> findByTeacher(Teacher teacher);
}
