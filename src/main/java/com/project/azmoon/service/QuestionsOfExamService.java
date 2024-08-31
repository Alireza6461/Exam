package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.Exam;
import com.project.azmoon.domain.QuestionsOfExam;

import java.util.List;

public interface QuestionsOfExamService extends BaseEntityService<QuestionsOfExam,Long> {

    List<QuestionsOfExam> findQuestionsOfExamByExam(Exam exam);
}
