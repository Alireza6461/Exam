package com.project.azmoon.domain;

import com.project.azmoon.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentAnswerDescriptiveQuestion extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn
    private DescriptiveQuestion descriptiveQuestion;

    @ManyToOne
    @JoinColumn
    private Student student;


    private String Answer;







}
