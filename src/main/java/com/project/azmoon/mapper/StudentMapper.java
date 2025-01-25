package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.Student;
import com.project.azmoon.service.dto.StudentCustomDto;
import com.project.azmoon.service.dto.StudentRegisterRequestDto;
import com.project.azmoon.service.dto.StudentRegisterResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student, StudentRegisterRequestDto, Long> {

    StudentRegisterResponseDto convertEntityToStudentRegisterResponseDto(Student student);

    List<StudentCustomDto> convertEntityToStudentCustomDtos(List<Student> students);

    StudentCustomDto convertEntityToStudentCustomDto(Student student);

}
