package com.project.azmoon.repository;

import com.project.azmoon.domain.DescriptiveQuestion;
import com.project.azmoon.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptiveQuestionRepository extends JpaRepository<DescriptiveQuestion,Long>, JpaSpecificationExecutor<DescriptiveQuestion> {

    List<DescriptiveQuestion> findByTeacher(Teacher teacher);
}
