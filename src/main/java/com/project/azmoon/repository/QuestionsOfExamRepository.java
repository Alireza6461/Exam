package com.project.azmoon.repository;

import com.project.azmoon.domain.Exam;
import com.project.azmoon.domain.QuestionsOfExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsOfExamRepository extends JpaRepository<QuestionsOfExam,Long> , JpaSpecificationExecutor<QuestionsOfExam> {

    List<QuestionsOfExam> findQuestionsOfExamByExam(Exam exam);
}
