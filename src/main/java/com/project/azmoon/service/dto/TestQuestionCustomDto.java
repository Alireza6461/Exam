package com.project.azmoon.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class TestQuestionCustomDto {

    private String questionForm;

    private List<MultipleChoiceCustomDto> multipleChoiceCustomDtos;

    public TestQuestionCustomDto(String questionForm, List<MultipleChoiceCustomDto> multipleChoiceCustomDtos) {
        this.questionForm = questionForm;
        this.multipleChoiceCustomDtos = multipleChoiceCustomDtos;
    }

    public TestQuestionCustomDto(List<MultipleChoiceCustomDto> multipleChoiceCustomDtos) {
        this.multipleChoiceCustomDtos = multipleChoiceCustomDtos;
    }

    public TestQuestionCustomDto(String questionForm) {
        this.questionForm = questionForm;
    }

    public TestQuestionCustomDto() {
    }
}
