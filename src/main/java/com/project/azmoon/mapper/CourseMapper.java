package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.Course;
import com.project.azmoon.service.dto.CourseCustomDto;
import com.project.azmoon.service.dto.CourseDto;
import com.project.azmoon.service.dto.CourseResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course, CourseDto,Long> {

    List<CourseCustomDto> convertEntityToDto(List<Course> course);
}
