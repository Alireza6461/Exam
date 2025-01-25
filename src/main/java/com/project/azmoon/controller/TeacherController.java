package com.project.azmoon.controller;

import com.project.azmoon.domain.*;
import com.project.azmoon.domain.enums.Role;
import com.project.azmoon.mapper.*;
import com.project.azmoon.service.*;
import com.project.azmoon.service.dto.*;
import com.project.azmoon.service.dto.searchdto.TeacherRequestSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;
    private final TeacherMapper teacherMapper;
    private final CourseMapper courseMapper;
    private final DescriptiveQuestionService descriptiveQuestionService;
    private final DescriptiveQuestionMapper descriptiveQuestionMapper;
    private final TestQuestionService testQuestionService;
    private final TestQuestionMapper testQuestionMapper;
    private final QuestionsOfExamService questionsOfExamService;
    private final ExamService examService;
    private final MultipleChoiceService multipleChoiceService;
    private final MultipleChoiceMapper multipleChoiceMapper;


    @PostMapping("/login")
    public ResponseEntity<TeacherCustomDto> loginTeacher(@RequestBody TeacherRequestSearch teacherRequestSearch ){

        TeacherCustomDto teacherCustomDto=new TeacherCustomDto();
        Teacher teacher=teacherService.findByUsername(teacherRequestSearch.getUserName());
        if (teacherRequestSearch.getPassword().equals(teacher.getPassword())) {

            teacherCustomDto=teacherMapper.convertEntityToTeacherCustomDto(teacher);
            return ResponseEntity.status(HttpStatus.OK).body(teacherCustomDto);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(teacherCustomDto);


    }
    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody TeacherRegisterRequestDto teacherRegisterRequestDto){
       Teacher teacher=teacherMapper.convertDTOToEntity(teacherRegisterRequestDto);
       teacher.setRole(Role.TEACHER);
        teacherService.save(teacher);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/show-teacher")
    public List<Teacher> showTeacher(){

        return teacherService.findByIsActiveTrue();
    }

    @GetMapping("/show-course")
    public List<CourseDto> showCourses(@RequestParam Long id){

        Optional<Teacher> teacher=teacherService.findById(id);
        List<Course> courseList=courseService.findByTeacher(teacher.get());
        return courseMapper.convertEntityListToDTOList(courseList);
    }

    @GetMapping("/show-descriptiveQuestion")
    public List<DescriptiveQuestionDto> showDescriptiveQuestion(@RequestParam Long idTeacher){
        Optional<Teacher> teacher=teacherService.findById(idTeacher);

        List<DescriptiveQuestion> descriptiveQuestions=descriptiveQuestionService.findByTeacher(teacher.get());
        return descriptiveQuestionMapper.convertEntityListToDTOList(descriptiveQuestions);

    }

    @GetMapping("/show-testQuestion")
    public List<TestQuestionCustomDto> showTestQuestion(@RequestParam Long idTeacher){
        Optional<Teacher> teacher=teacherService.findById(idTeacher);
        List<TestQuestion> testQuestions=testQuestionService.findByTeacher(teacher.get());
        List<TestQuestionCustomDto> testQuestionCustomDtos=new ArrayList<>();
        for (TestQuestion testQuestion :testQuestions){
           TestQuestionCustomDto testQuestionCustomDto=new TestQuestionCustomDto();
           testQuestionCustomDto.setQuestionForm(testQuestion.getQuestionForm());
           List<MultipleChoice>multipleChoices=multipleChoiceService.findMultipleChoicesByTestQuestion(testQuestion);
           List<MultipleChoiceCustomDto> multipleChoiceCustomDtos=multipleChoiceMapper.convertEntityListToDtoList(multipleChoices);
           testQuestionCustomDto.setMultipleChoiceCustomDtos(multipleChoiceCustomDtos);
           testQuestionCustomDtos.add(testQuestionCustomDto);
        }
        return testQuestionCustomDtos;
    }

    @PostMapping(value = "/define-descriptiveQuestion" , consumes = "application/json")
    public ResponseEntity defineDescriptiveQuestion(@RequestParam Long idTeacher, @RequestBody DescriptiveQuestion descriptiveQuestion){
        Optional<Teacher> teacher=teacherService.findById(idTeacher);
        descriptiveQuestion.setTeacher(teacher.get());
        descriptiveQuestionService.save(descriptiveQuestion);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PostMapping(value = "/define-testQuestion", consumes = "application/json")
    public ResponseEntity<TestQuestionDto> defineTestQuestion(@RequestParam Long idTeacher, @RequestBody TestQuestion testQuestion){
        Optional<Teacher> teacher=teacherService.findById(idTeacher);
        testQuestion.setTeacher(teacher.get());
        testQuestionService.save(testQuestion);
        TestQuestionDto testQuestionDto=testQuestionMapper.convertEntityToDTO(testQuestion);
        return ResponseEntity.status(HttpStatus.OK).body(testQuestionDto);
    }
    @PostMapping("/define-multipleChoices")
    private ResponseEntity defineMultipleChoices(@RequestParam Long idTestQuestion,@RequestBody List<MultipleChoice> multipleChoices){

        TestQuestion testQuestion=testQuestionService.findById(idTestQuestion).get();
        for (int i=0; i < multipleChoices.size();i++) {
            multipleChoices.get(i).setTestQuestion(testQuestion);
            multipleChoiceService.save(multipleChoices.get(i));
        }
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PostMapping("/define-QuestionsOfExam")
    public ResponseEntity defineQuestionsOfExam(@RequestParam Long idExam,Long idDescriptiveQuestion,Long idTestQuestion){
        Exam exam=examService.findById(idExam).get();
        TestQuestion testQuestion=testQuestionService.findById(idTestQuestion).get();
        DescriptiveQuestion descriptiveQuestion=descriptiveQuestionService.findById(idDescriptiveQuestion).get();
        QuestionsOfExam questionsOfExam=new QuestionsOfExam(exam,descriptiveQuestion,testQuestion);
        questionsOfExamService.save(questionsOfExam);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
