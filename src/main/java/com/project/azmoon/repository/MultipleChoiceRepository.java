package com.project.azmoon.repository;

import com.project.azmoon.domain.MultipleChoice;
import com.project.azmoon.domain.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultipleChoiceRepository extends JpaRepository<MultipleChoice,Long> , JpaSpecificationExecutor<MultipleChoice> {

    List<MultipleChoice> findMultipleChoicesByTestQuestion(TestQuestion testQuestion);
}
