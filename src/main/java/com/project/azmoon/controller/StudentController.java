package com.project.azmoon.controller;

import com.project.azmoon.domain.*;
import com.project.azmoon.domain.enums.ExamStatus;
import com.project.azmoon.domain.enums.Role;
import com.project.azmoon.mapper.*;
import com.project.azmoon.service.*;
import com.project.azmoon.service.dto.*;
import com.project.azmoon.service.dto.searchdto.StudentRequestSearch;
import com.project.azmoon.service.dto.searchdto.TeacherRequestSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final QuestionsOfExamService questionsOfExamService;
    private final QuestionsOfExamMapper questionsOfExamMapper;
    private final ExamService examService;
    private final DescriptiveQuestionMapper descriptiveQuestionMapper;
    private final TestQuestionMapper testQuestionMapper;
    private final MultipleChoiceMapper multipleChoiceMapper;
    private final MultipleChoiceService multipleChoiceService;
    private final StudentAnswerDescriptiveQuestionService studentAnswerDescriptiveQuestionService;
    private final StudentAnswerTestQuestionService studentAnswerTestQuestionService;
    private final DescriptiveQuestionService descriptiveQuestionService;
    private final TestQuestionService testQuestionService;
    private final ResultStudentExamService resultStudentExamService;
    private final StudentCoursesService studentCoursesService;
    private final CourseMapper courseMapper;
    private final CourseService courseService;
    private final ExamMapper examMapper;

    private LocalTime timeStartExam;
    private LocalTime timeFinishExam;


    @PostMapping("/login")
    public ResponseEntity<StudentCustomDto> loginTeacher(@RequestBody StudentRequestSearch studentRequestSearch) {

        StudentCustomDto studentCustomDto = new StudentCustomDto();
        Student student = studentService.findByUsername(studentRequestSearch.getUserName());
        if (studentRequestSearch.getPassword().equals(student.getPassword())) {

            studentCustomDto = studentMapper.convertEntityToStudentCustomDto(student);
            return ResponseEntity.status(HttpStatus.OK).body(studentCustomDto);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentCustomDto);


    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody StudentRegisterRequestDto studentRegisterRequestDto) {
        Student student = studentMapper.convertDTOToEntity(studentRegisterRequestDto);
        student.setRole(Role.STUDENT);
        studentService.save(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/show-courses")
    public ResponseEntity<List<CourseCustomDto>> showStudentCourses(@RequestParam Long idStudent) {
        Student student = studentService.findById(idStudent).get();
        List<Course> courses = studentCoursesService.findByStudent(student)
                .stream()
                .map(StudentCourses::getCourse)
                .collect(Collectors.toList());
        List<CourseCustomDto> courseCustomDtos = courseMapper.convertEntityToDto(courses);
        return ResponseEntity.status(HttpStatus.FOUND).body(courseCustomDtos);
    }

    @GetMapping("/show-exam-course")
    public ResponseEntity<List<ExamDto>> showCourseExams(@RequestParam Long idCourse) {
        Course course = courseService.findById(idCourse).orElse(null);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Exam> exams = examService.findByCourse(course);
        Iterator<Exam> iterator = exams.iterator();
        while (iterator.hasNext()) {
            Exam exam = iterator.next();
            if (exam.getDate().isBefore(LocalDate.now())) {
                iterator.remove();  // حذف ایمن از لیست در حین پیمایش
            }
        }

        List<ExamDto> examDtos = examMapper.convertEntityListToDTOList(exams);
        return ResponseEntity.status(HttpStatus.FOUND).body(examDtos);
    }


}

