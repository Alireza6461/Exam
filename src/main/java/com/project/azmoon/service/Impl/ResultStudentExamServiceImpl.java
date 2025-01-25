package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.Exam;
import com.project.azmoon.domain.ResultStudentExam;
import com.project.azmoon.domain.Student;
import com.project.azmoon.repository.ResultStudentExamRepository;
import com.project.azmoon.service.ResultStudentExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResultStudentExamServiceImpl extends BaseEntityServiceImpl<ResultStudentExam,Long, ResultStudentExamRepository> implements ResultStudentExamService {
    public ResultStudentExamServiceImpl(ResultStudentExamRepository repository) {
        super(repository);
    }

    @Override
    public List<ResultStudentExam> findByStudent(Student student) {
        return repository.findByStudent(student);
    }

    @Override
    public ResultStudentExam findByStudentAndExam(Student student, Exam exam) {
        return repository.findByStudentAndExam(student,exam);
    }
}
