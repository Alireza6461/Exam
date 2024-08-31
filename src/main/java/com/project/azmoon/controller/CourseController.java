package com.project.azmoon.controller;

import com.project.azmoon.domain.*;
import com.project.azmoon.domain.enums.ExamStatus;
import com.project.azmoon.mapper.ExamMapper;
import com.project.azmoon.service.*;
import com.project.azmoon.service.dto.ExamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final StudentCoursesService studentCoursesService;
    private final ExamMapper examMapper;
    private final ExamService examService;
    private final ResultStudentExamService resultStudentExamService;


    @GetMapping("/show-course")
    public List<Course> showCourse(){
        return courseService.findAll();
    }

    @PostMapping("/define-course")
    public ResponseEntity.BodyBuilder defineCourse(@RequestBody Course course) {
        System.out.println(course.getDateOfStart());
        if (course.getDateOfStart().isAfter(LocalDate.now()) && course.getDateOfFinish().isAfter(course.getDateOfStart())) {
            courseService.save(course);
            return ResponseEntity.status(HttpStatus.ACCEPTED);
        }
        else {return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE);}
    }

    @PostMapping("/add-teacher-to-course")
    public ResponseEntity.BodyBuilder addTeacherToCourse(@RequestParam Long id,Long idTeacher){
        Optional<Course> course=courseService.findById(id);
        Optional<Teacher> teacher=teacherService.findById(idTeacher);
        course.get().setTeacher(teacher.get());
        courseService.save(course.get());
        return ResponseEntity.status(HttpStatus.ACCEPTED);

    }

    @PostMapping("/add-student-to-course")
    public void addStudentToCourse(@RequestParam Long id,Long idStudent){
        Optional<Course> course=courseService.findById(id);
        Optional<Student> student=studentService.findById(idStudent);
        StudentCourses studentCourses=new StudentCourses(course.get(),student.get());
        studentCoursesService.save(studentCourses);
    }

    @PostMapping("/define-exam")
    public void defineExam(@RequestParam Long id, @RequestBody ExamDto examDto){
        Optional<Course> course=courseService.findById(id);
        Exam exam=examMapper.convertDTOToEntity(examDto);
        exam.setCourse(course.get());
        examService.save(exam);
        List<StudentCourses> studentCourses=studentCoursesService.findByCourse(course.get());
        for (int i=0;i<studentCourses.size();i++) {
            Student student=studentCourses.get(i).getStudent();
            ResultStudentExam resultStudentExam=new ResultStudentExam();
            resultStudentExam.setExam(exam);
            resultStudentExam.setStudent(student);
            resultStudentExam.setExamStatus(ExamStatus.NOT_STARTED);
            resultStudentExamService.save(resultStudentExam);

        }
    }

    @GetMapping("/show-exam")
    public List<ExamDto> showExamOfCourse(@RequestParam Long id){
        Optional<Course> course=courseService.findById(id);
        List<Exam> examList=examService.findByCourse(course.get());
        return examMapper.convertEntityListToDTOList(examList);
    }


}
