package com.project.azmoon.service.dto;

import com.project.azmoon.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestQuestionResponseDto extends BaseDto<Long> {

    private String questionForm;

    private List<MultipleChoiceDto> multipleChoiceDtos;
}
