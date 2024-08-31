package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.TestQuestion;
import com.project.azmoon.service.dto.TestQuestionDto;
import org.mapstruct.Mapper;

@Mapper
public interface TestQuestionMapper extends BaseMapper<TestQuestion, TestQuestionDto,Long> {
}
