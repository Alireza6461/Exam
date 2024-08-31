package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Exam;
import com.project.azmoon.repository.ExamRepository;
import com.project.azmoon.service.ExamService;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExamServiceImpl extends BaseEntityServiceImpl<Exam,Long, ExamRepository> implements ExamService {
    public ExamServiceImpl(ExamRepository repository) {
        super(repository);
    }

    @Override
    public List<Exam> findByCourse(Course course) {
        return repository.findByCourse(course);
    }
}
