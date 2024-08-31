package com.project.azmoon.repository;

import com.project.azmoon.domain.Teacher;
import com.project.azmoon.domain.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion,Long>, JpaSpecificationExecutor<TestQuestion> {

    List<TestQuestion> findByTeacher(Teacher teacher);
}
