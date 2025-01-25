package com.project.azmoon.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User {

    @Column
    private String studentCode;

    @Column
    private String mobileNumber;

    @OneToMany(mappedBy = "student")
    private List<StudentCourses> studentCourses;

    @OneToMany(mappedBy = "student")
    private List<StudentAnswerDescriptiveQuestion> studentAnswerDescriptiveQuestions;

    @OneToMany(mappedBy = "student")
    private List<StudentAnswerTestQuestion> studentAnswerTestQuestions;

    @OneToMany(mappedBy = "student")
    private List<ResultStudentExam> resultStudentExamList;




}
