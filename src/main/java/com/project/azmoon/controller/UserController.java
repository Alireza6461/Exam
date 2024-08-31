package com.project.azmoon.controller;


import com.project.azmoon.domain.Student;
import com.project.azmoon.domain.Teacher;
import com.project.azmoon.domain.enums.Role;
import com.project.azmoon.mapper.StudentMapper;
import com.project.azmoon.mapper.TeacherMapper;
import com.project.azmoon.service.StudentService;
import com.project.azmoon.service.TeacherService;
import com.project.azmoon.service.dto.StudentRegisterRequestDto;
import com.project.azmoon.service.dto.TeacherRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final StudentService studentService;
    private final TeacherService teacherService;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    @PostMapping("/Student-sign-up")
    public ResponseEntity signUpStudent(@RequestBody StudentRegisterRequestDto studentRegisterRequestDto){

        Student student=studentMapper.convertDTOToEntity(studentRegisterRequestDto);
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/teacher-sign-up")
    public ResponseEntity signUpTeacher(@RequestBody TeacherRegisterRequestDto teacherRegisterRequestDto){

        Teacher teacher=teacherMapper.convertDTOToEntity(teacherRegisterRequestDto);
        teacherService.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
