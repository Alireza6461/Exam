package com.project.azmoon.service.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAnswerQuestionDto {

    private Long idQuestion;

    private String answerDescriptiveQuestion;

    private Long answerTestQuestion;

}
