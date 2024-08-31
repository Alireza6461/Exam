package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.Teacher;
import com.project.azmoon.domain.TestQuestion;
import com.project.azmoon.repository.TestQuestionRepository;
import com.project.azmoon.service.TestQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestQuestionServiceImpl extends BaseEntityServiceImpl<TestQuestion,Long, TestQuestionRepository> implements TestQuestionService {
    public TestQuestionServiceImpl(TestQuestionRepository repository) {
        super(repository);
    }

    @Override
    public List<TestQuestion> findByTeacher(Teacher teacher) {
        return repository.findByTeacher(teacher);
    }
}
