package com.project.azmoon.controller;


import com.project.azmoon.domain.Manager;
import com.project.azmoon.domain.Student;
import com.project.azmoon.domain.Teacher;
import com.project.azmoon.mapper.ManagerMapper;
import com.project.azmoon.mapper.StudentMapper;
import com.project.azmoon.mapper.TeacherMapper;
import com.project.azmoon.service.ManagerService;
import com.project.azmoon.service.StudentService;
import com.project.azmoon.service.TeacherService;
import com.project.azmoon.service.dto.StudentCustomDto;
import com.project.azmoon.service.dto.TeacherCustomDto;
import com.project.azmoon.service.dto.searchdto.ManagerResponseSearchDto;
import com.project.azmoon.service.dto.searchdto.MangerRequestSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class MangerController {

    private final ManagerService managerService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;

    @PostMapping("/login")
    public ResponseEntity<ManagerResponseSearchDto> loginManger(@RequestBody MangerRequestSearch mangerRequestSearch ){

        ManagerResponseSearchDto managerResponseSearchDto=new ManagerResponseSearchDto();
        Manager manager =managerService.findByUserName(mangerRequestSearch.getUserName());
        if (mangerRequestSearch.getPassword().equals(manager.getPassword())) {

             managerResponseSearchDto.setFirstName(manager.getFirstName());
             managerResponseSearchDto.setLastName(manager.getLastName());
             return ResponseEntity.status(HttpStatus.FOUND).body(managerResponseSearchDto);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


    }
    @PutMapping("/active-student")
    public ResponseEntity studentIsNotActive(@RequestParam List<Long> id) {
        for (Long studentId : id) {
            Optional<Student> student = studentService.findById(studentId);
            if (student.isPresent()) {
                student.get().setIsActive(true);
                studentService.save(student.get());
            } else {

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student with ID " + studentId + " not found.");
            }
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/show-student-is-not-active")
    public List<StudentCustomDto> showStudentIsNotActive(){
        return studentMapper.convertEntityToStudentCustomDtos(studentService.findByIsActiveFalse());
    }

    @GetMapping("/show-student")
    public List<StudentCustomDto> showStudent(){
        return studentMapper.convertEntityToStudentCustomDtos(studentService.findByIsActiveTrue());
    }

    @PutMapping("/active-teacher")
    public ResponseEntity teacherIsNotActive(@RequestParam List<Long> id) {
        for (Long teacherId : id) {
            Optional<Teacher> teacher = teacherService.findById(teacherId);
            if (teacher.isPresent()) {
                teacher.get().setIsActive(true);
                teacherService.save(teacher.get());
            } else {

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Teacher with ID " + teacherId + " not found.");
            }
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }



    @GetMapping("/show-teacher-is-not-active")
    public List<TeacherCustomDto> showTeacherIsNotActive(){

        return teacherMapper.convertEntityToTeacherCustomDto(teacherService.findByIsActiveFalse());
    }
}
