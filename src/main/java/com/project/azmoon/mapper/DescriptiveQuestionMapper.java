package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.DescriptiveQuestion;
import com.project.azmoon.service.dto.DescriptiveQuestionDto;
import org.mapstruct.Mapper;

@Mapper
public interface DescriptiveQuestionMapper extends BaseMapper <DescriptiveQuestion,DescriptiveQuestionDto,Long>{
}
