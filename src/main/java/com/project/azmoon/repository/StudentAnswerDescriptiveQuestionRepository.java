package com.project.azmoon.repository;

import com.project.azmoon.domain.StudentAnswerDescriptiveQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAnswerDescriptiveQuestionRepository extends JpaRepository<StudentAnswerDescriptiveQuestion,Long> , JpaSpecificationExecutor<StudentAnswerDescriptiveQuestion> {
}
