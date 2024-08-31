package com.project.azmoon.repository;

import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> , JpaSpecificationExecutor<Exam> {

    List<Exam> findByCourse(Course course);
}
