package com.project.azmoon.repository;

import com.project.azmoon.domain.Exam;
import com.project.azmoon.domain.ResultStudentExam;
import com.project.azmoon.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultStudentExamRepository extends JpaRepository<ResultStudentExam,Long>, JpaSpecificationExecutor<ResultStudentExam> {

    List<ResultStudentExam> findByStudent(Student student);

    ResultStudentExam findByStudentAndExam(Student student, Exam exam);


}
