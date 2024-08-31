package com.project.azmoon.mapper;


import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.Student;
import com.project.azmoon.domain.Teacher;
import com.project.azmoon.service.dto.StudentRegisterRequestDto;
import com.project.azmoon.service.dto.TeacherCustomDto;
import com.project.azmoon.service.dto.TeacherRegisterRequestDto;
import com.project.azmoon.service.dto.TeacherRegisterResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher, TeacherRegisterRequestDto, Long> {

    TeacherRegisterResponseDto convertEntityToTeacherRegisterResponseDto(Teacher teacher);

    List<TeacherCustomDto> convertEntityToTeacherCustomDto(List<Teacher> teachers);
}
