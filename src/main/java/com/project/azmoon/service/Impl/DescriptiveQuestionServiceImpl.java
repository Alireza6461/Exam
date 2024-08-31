package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.DescriptiveQuestion;
import com.project.azmoon.domain.Teacher;
import com.project.azmoon.repository.DescriptiveQuestionRepository;
import com.project.azmoon.service.DescriptiveQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DescriptiveQuestionServiceImpl extends BaseEntityServiceImpl<DescriptiveQuestion,Long, DescriptiveQuestionRepository> implements DescriptiveQuestionService {
    public DescriptiveQuestionServiceImpl(DescriptiveQuestionRepository repository) {
        super(repository);
    }

    @Override
    public List<DescriptiveQuestion> findByTeacher(Teacher teacher) {
        return repository.findByTeacher(teacher);
    }
}
