package com.project.azmoon.domain;

import com.project.azmoon.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class  QuestionsOfExam extends BaseEntity<Long> {

    @ManyToOne
    private Exam exam;

    @ManyToOne
    private DescriptiveQuestion descriptiveQuestion;

    @ManyToOne
    private TestQuestion testQuestion;
}
