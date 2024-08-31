package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.Exam;
import com.project.azmoon.service.dto.ExamDto;
import org.mapstruct.Mapper;

@Mapper
public interface ExamMapper extends BaseMapper<Exam, ExamDto,Long> {
}
