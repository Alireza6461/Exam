package com.project.azmoon.service.dto;

import com.project.azmoon.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MultipleChoiceDto extends BaseDto<Long> {

    private String choice;
}
