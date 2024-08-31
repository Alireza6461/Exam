package com.project.azmoon.domain;

import com.project.azmoon.base.domain.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DescriptiveQuestion extends BaseEntity<Long> {

    private String questionForm;


    private float scoreQuestion;


    @OneToMany(mappedBy = "descriptiveQuestion")
    private List<StudentAnswerDescriptiveQuestion> studentAnswerDescriptiveQuestions ;

    @OneToMany(mappedBy = "descriptiveQuestion")
    private List<QuestionsOfExam> questionsOfExams;

    @ManyToOne
    private Teacher teacher;


}
