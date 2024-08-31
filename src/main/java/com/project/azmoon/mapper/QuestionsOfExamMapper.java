package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.QuestionsOfExam;
import com.project.azmoon.service.dto.QuestionsOfExamDto;
import org.mapstruct.Mapper;

@Mapper
public interface QuestionsOfExamMapper extends BaseMapper<QuestionsOfExam, QuestionsOfExamDto,Long> {
}
