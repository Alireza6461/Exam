package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.StudentAnswerDescriptiveQuestion;
import com.project.azmoon.repository.StudentAnswerDescriptiveQuestionRepository;
import com.project.azmoon.service.StudentAnswerDescriptiveQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentAnswerDescriptiveQuestionServiceImpl extends BaseEntityServiceImpl<StudentAnswerDescriptiveQuestion,Long, StudentAnswerDescriptiveQuestionRepository> implements StudentAnswerDescriptiveQuestionService {
    public StudentAnswerDescriptiveQuestionServiceImpl(StudentAnswerDescriptiveQuestionRepository repository) {
        super(repository);
    }
}
