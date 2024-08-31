package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.Exam;
import com.project.azmoon.domain.QuestionsOfExam;
import com.project.azmoon.repository.QuestionsOfExamRepository;
import com.project.azmoon.service.QuestionsOfExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionsOfExamServiceImpl extends BaseEntityServiceImpl<QuestionsOfExam,Long, QuestionsOfExamRepository> implements QuestionsOfExamService {
    public QuestionsOfExamServiceImpl(QuestionsOfExamRepository repository) {
        super(repository);
    }

    @Override
    public List<QuestionsOfExam> findQuestionsOfExamByExam(Exam exam) {
        return repository.findQuestionsOfExamByExam(exam);
    }
}
