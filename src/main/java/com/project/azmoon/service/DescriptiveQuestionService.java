package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.DescriptiveQuestion;
import com.project.azmoon.domain.Teacher;

import java.util.List;

public interface DescriptiveQuestionService extends BaseEntityService<DescriptiveQuestion,Long> {
    List<DescriptiveQuestion> findByTeacher(Teacher teacher);
}
