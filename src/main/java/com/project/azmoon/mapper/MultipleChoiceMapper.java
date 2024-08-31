package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.MultipleChoice;
import com.project.azmoon.service.dto.MultipleChoiceDto;
import org.mapstruct.Mapper;

@Mapper
public interface MultipleChoiceMapper extends BaseMapper<MultipleChoice, MultipleChoiceDto,Long> {
}
