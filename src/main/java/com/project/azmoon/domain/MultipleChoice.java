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
public class MultipleChoice extends BaseEntity<Long> {

    private String choice;

    @ManyToOne(cascade = CascadeType.ALL)
    private TestQuestion testQuestion;

    private boolean trueAnswer;

    @OneToMany
    private List<StudentAnswerTestQuestion> studentAnswerTestQuestion;
}
