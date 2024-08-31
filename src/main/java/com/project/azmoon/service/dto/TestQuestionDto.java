package com.project.azmoon.service.dto;

import com.project.azmoon.base.dto.BaseDto;
import com.project.azmoon.domain.MultipleChoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestQuestionDto extends BaseDto<Long> {

    private String questionForm;

    private List<MultipleChoice> multipleChoices;
}
