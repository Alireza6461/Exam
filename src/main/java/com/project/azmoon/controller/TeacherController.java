package com.project.azmoon.controller;

import com.project.azmoon.domain.*;
import com.project.azmoon.mapper.CourseMapper;
import com.project.azmoon.mapper.DescriptiveQuestionMapper;
import com.project.azmoon.mapper.ExamMapper;
import com.project.azmoon.mapper.TestQuestionMapper;
import com.project.azmoon.service.*;
import com.project.azmoon.service.dto.CourseResponseDto;
import com.project.azmoon.service.dto.DescriptiveQuestionDto;
import com.project.azmoon.service.dto.ExamDto;
import com.project.azmoon.service.dto.TestQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;
    private final CourseMapper courseMapper;
    private final DescriptiveQuestionService descriptiveQuestionService;
    private final DescriptiveQuestionMapper descriptiveQuestionMapper;
    private final TestQuestionService testQuestionService;
    private final TestQuestionMapper testQuestionMapper;
    private final QuestionsOfExamService questionsOfExamService;
    private final ExamService examService;
    private final MultipleChoiceService multipleChoiceService;


    @GetMapping("/active-teacher")
    public void teacherIsNotActive(@RequestParam Long id){
        Optional<Teacher> teacher=teacherService.findById(id);
        teacher.get().setIsActive(true);
        teacherService.save(teacher.get());

    }



    @GetMapping("/show-teacher-is-not-active")
    public List<Teacher> showTeacherIsNotActive(){
        return teacherService.findByIsActiveFalse();
    }

    @GetMapping("/show-teacher")
    public List<Teacher> showTeacher(){

        return teacherService.findByIsActiveTrue();
    }

    @GetMapping("/show-course")
    public List<CourseResponseDto> showCourses(@RequestParam Long id){

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
    public List<TestQuestionDto> showTestQuestion(@RequestParam Long idTeacher){
        Optional<Teacher> teacher=teacherService.findById(idTeacher);
        List<TestQuestion> testQuestions=testQuestionService.findByTeacher(teacher.get());
        return testQuestionMapper.convertEntityListToDTOList(testQuestions);
    }

    @PostMapping("/define-descriptiveQuestion")
    public void defineDescriptiveQuestion(@RequestParam Long idTeacher,@RequestBody DescriptiveQuestion descriptiveQuestion){
        Optional<Teacher> teacher=teacherService.findById(idTeacher);
        descriptiveQuestion.setTeacher(teacher.get());
        descriptiveQuestionService.save(descriptiveQuestion);
    }

    @PostMapping("/define-testQuestion")
    public void defineTestQuestion(
            @RequestParam Long idTeacher,
            @RequestBody TestQuestion testQuestion){

        Optional<Teacher> teacher=teacherService.findById(idTeacher);
        testQuestion.setTeacher(teacher.get());
        testQuestionService.save(testQuestion);
    }
    @PostMapping("/define-multipleChoices")
    private void defineMultipleChoices(@RequestParam Long idTestQuestion,@RequestBody List<MultipleChoice> multipleChoices){

        TestQuestion testQuestion=testQuestionService.findById(idTestQuestion).get();
        for (int i=0; i < multipleChoices.size();i++) {
            multipleChoices.get(i).setTestQuestion(testQuestion);
            multipleChoiceService.save(multipleChoices.get(i));
        }

    }

    @PostMapping("/define-QuestionsOfExam")
    public void defineQuestionsOfExam(@RequestParam Long idExam,Long idDescriptiveQuestion,Long idTestQuestion){
        Exam exam=examService.findById(idExam).get();
        TestQuestion testQuestion=testQuestionService.findById(idTestQuestion).get();
        DescriptiveQuestion descriptiveQuestion=descriptiveQuestionService.findById(idDescriptiveQuestion).get();
        QuestionsOfExam questionsOfExam=new QuestionsOfExam(exam,descriptiveQuestion,testQuestion);
        questionsOfExamService.save(questionsOfExam);

    }

}
