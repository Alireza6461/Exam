package com.project.azmoon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.azmoon.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestQuestion extends BaseEntity<Long> {

    private String questionForm;


    private float scoreQuestion;

    @OneToMany
    private List<MultipleChoice> multipleChoices;


    @OneToMany(mappedBy = "testQuestion")
    private List<StudentAnswerTestQuestion> studentAnswerTestQuestions;

    @OneToMany(mappedBy = "testQuestion")
    private List<QuestionsOfExam> questionsOfExams;

    @ManyToOne
    private Teacher teacher;


}
