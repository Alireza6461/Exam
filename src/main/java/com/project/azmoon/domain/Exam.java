package com.project.azmoon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.azmoon.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Exam extends BaseEntity<Long> {

    @ManyToOne
    private Course course;

    private String title;

    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime finishTime;

    private float score;

    private int duration;

    @OneToMany(mappedBy = "exam")
    private List<ResultStudentExam> resultStudentExamList;

    @OneToMany(mappedBy = "exam")
    private List<QuestionsOfExam> questionsOfExams;

}
