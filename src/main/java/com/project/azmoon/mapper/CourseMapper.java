package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.Course;
import com.project.azmoon.service.dto.CourseDto;
import com.project.azmoon.service.dto.CourseResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course, CourseResponseDto,Long> {
}
