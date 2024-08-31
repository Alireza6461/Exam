package com.project.azmoon.service.dto;

import com.project.azmoon.base.dto.BaseDto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class QuestionsOfExamDto extends BaseDto<Long> {

   private DescriptiveQuestionDto descriptiveQuestionDto;
   private TestQuestionResponseDto testQuestionResponseDto ;
}
