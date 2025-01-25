package com.project.azmoon.controller;

import com.project.azmoon.domain.*;
import com.project.azmoon.domain.enums.ExamStatus;
import com.project.azmoon.mapper.CourseMapper;
import com.project.azmoon.mapper.ExamMapper;
import com.project.azmoon.service.*;
import com.project.azmoon.service.dto.CourseCustomDto;
import com.project.azmoon.service.dto.CourseDto;
import com.project.azmoon.service.dto.ExamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final StudentCoursesService studentCoursesService;
    private final CourseMapper courseMapper;
    private final ExamMapper examMapper;
    private final ExamService examService;
    private final ResultStudentExamService resultStudentExamService;


    @GetMapping("/show-course")
    public List<CourseCustomDto> showCourse(){
        return courseMapper.convertEntityToDto(courseService.findAll());
    }


    @PostMapping("/define-course")
    public ResponseEntity defineCourse(@RequestBody Course course) {
        System.out.println("Received course: " + course);

        if (course.getDateOfStart().isAfter(LocalDate.now()) && course.getDateOfFinish().isAfter(course.getDateOfStart())) {
            courseService.save(course);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }




    @PostMapping("/add-teacher-to-course")
    public ResponseEntity addTeacherToCourse(@RequestParam Long id,String teacherCode){
        Optional<Course> course=courseService.findById(id);
        Teacher teacher=teacherService.findByTeacherCode(teacherCode);
        course.get().setTeacher(teacher);
        courseService.save(course.get());
        return ResponseEntity.status(HttpStatus.OK).build();

    }


    @PostMapping("/add-student-to-course")
    public ResponseEntity addStudentToCourse(@RequestParam Long idCourse, @RequestParam List<Long> idStudent) {

        Optional<Course> course = courseService.findById(idCourse);
        for (Long studentId : idStudent) {
            Optional<Student> student = studentService.findById(studentId);
            if (student.isPresent()) {
                StudentCourses studentCourses = new StudentCourses(course.get(), student.get());
                studentCoursesService.save(studentCourses);
                LocalDate now = LocalDate.now();
                ResultStudentExam resultStudentExam = new ResultStudentExam();
                for (int i = 0; i < course.get().getExams().size(); i++) {
                    if (course.get().getExams().get(i).getDate().isAfter(now)) {
                        resultStudentExam.setStudent(student.get());
                        resultStudentExam.setExam(course.get().getExams().get(i));
                        resultStudentExam.setExamStatus(ExamStatus.NOT_STARTED);
                        resultStudentExamService.save(resultStudentExam);
                    }
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student with ID " + studentId + " not found.");
            }
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }




    @PostMapping("/define-exam")
    public ResponseEntity defineExam(@RequestParam Long idCourse, @RequestBody ExamDto examDto){
        Optional<Course> course=courseService.findById(idCourse);
        Exam exam=examMapper.convertDTOToEntity(examDto);
        exam.setCourse(course.get());
        examService.save(exam);
        List<StudentCourses> studentCourses=studentCoursesService.findByCourse(course.get());
        for (int i=0;i<studentCourses.size();i++) {
            Student student=studentCourses.get(i).getStudent();
            if(resultStudentExamService.findByStudentAndExam(student,exam)==null) {
                ResultStudentExam resultStudentExam = new ResultStudentExam();
                resultStudentExam.setExam(exam);
                resultStudentExam.setStudent(student);
                resultStudentExam.setExamStatus(ExamStatus.NOT_STARTED);
                resultStudentExamService.save(resultStudentExam);
            }

        }
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/show-exam")
    public List<ExamDto> showExamOfCourse(@RequestParam Long id){
        Optional<Course> course=courseService.findById(id);
        List<Exam> examList=examService.findByCourse(course.get());
        return examMapper.convertEntityListToDTOList(examList);
    }


}
