package com.project.azmoon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.azmoon.base.domain.BaseEntity;
import com.project.azmoon.domain.enums.ExamStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ResultStudentExam extends BaseEntity<Long> {

    @ManyToOne
    private Exam exam;

    @ManyToOne
    private Student student;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime time; //زمان و تاریخ باقی مانده آزمون

    @Enumerated(EnumType.STRING)
    private ExamStatus examStatus;

    private float score=0;

    public ResultStudentExam(Exam exam, Student student, LocalTime timeFinishExam, ExamStatus examStatus) {
    }
}
