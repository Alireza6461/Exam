package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.StudentAnswerTestQuestion;
import com.project.azmoon.repository.StudentAnswerTestQuestionRepository;
import com.project.azmoon.service.StudentAnswerTestQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentAnswerTestQuestionServiceImpl extends BaseEntityServiceImpl<StudentAnswerTestQuestion,Long, StudentAnswerTestQuestionRepository> implements StudentAnswerTestQuestionService {
    public StudentAnswerTestQuestionServiceImpl(StudentAnswerTestQuestionRepository repository) {
        super(repository);
    }
}
