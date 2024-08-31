package com.project.azmoon.controller;

import com.project.azmoon.domain.*;
import com.project.azmoon.domain.enums.ExamStatus;
import com.project.azmoon.mapper.DescriptiveQuestionMapper;
import com.project.azmoon.mapper.MultipleChoiceMapper;
import com.project.azmoon.mapper.QuestionsOfExamMapper;
import com.project.azmoon.mapper.TestQuestionMapper;
import com.project.azmoon.service.*;
import com.project.azmoon.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
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

    private LocalTime timeStartExam;
    private LocalTime timeFinishExam;

    @GetMapping("/active-student")
    public void studentIsNotActive(@RequestParam Long id){
        Optional<Student> student=studentService.findById(id);
        student.get().setIsActive(true);
        studentService.save(student.get());

    }

    @GetMapping("/show-student-is-not-active")
    public List<Student>  showStudentIsNotActive(){
        return studentService.findByIsActiveFalse();
    }

    @GetMapping("/show-student")
    public List<Student> showStudent(){

        return studentService.findByIsActiveTrue();
    }

    @GetMapping("/showQuestionsOfExam")
    public List<QuestionsOfExamDto> showQuestionsOfExam (@RequestParam Long idExam,Long idStudent) {
        Exam exam = examService.findById(idExam).get();
        Student student=studentService.findById(idStudent).get();
        ResultStudentExam resultStudentExam=resultStudentExamService.findByStudent(student);
        timeStartExam = LocalTime.now();
        timeFinishExam = LocalTime.now().plusMinutes(exam.getDuration());

            if (resultStudentExam.getExamStatus().equals(ExamStatus.NOT_STARTED)) {

                if (exam.getDate().isEqual(LocalDate.now()) &
                        timeStartExam.isAfter(exam.getStartTime()) &
                        timeFinishExam.isBefore(exam.getFinishTime())) {
                    resultStudentExam.setExamStatus(ExamStatus.PROGRESS);
                    resultStudentExam.setTime(timeFinishExam);
                    List<QuestionsOfExam> questionsOfExams = questionsOfExamService.findQuestionsOfExamByExam(exam);
                    List<DescriptiveQuestionDto> descriptiveQuestionDtos = new ArrayList<>();
                    List<TestQuestionResponseDto> testQuestionResponseDtos = new ArrayList<>();
                    List<QuestionsOfExamDto> questionsOfExamDtos = new ArrayList<>();
                    for (int i = 0; i < questionsOfExams.size(); i++) {
                        descriptiveQuestionDtos.add(i, descriptiveQuestionMapper.convertEntityToDTO(questionsOfExams.get(i).getDescriptiveQuestion()));
                        List<MultipleChoice> multipleChoices = multipleChoiceService.findMultipleChoicesByTestQuestion(questionsOfExams.get(i).getTestQuestion());
                        List<MultipleChoiceDto> multipleChoiceDtos = multipleChoiceMapper.convertEntityListToDTOList(multipleChoices);
                        TestQuestionResponseDto testQuestionResponseDto = new TestQuestionResponseDto(questionsOfExams.get(i).getTestQuestion().getQuestionForm(), multipleChoiceDtos);
                        testQuestionResponseDtos.add(i, testQuestionResponseDto);
                        QuestionsOfExamDto questionsOfExamDto = new QuestionsOfExamDto(descriptiveQuestionDtos.get(i), testQuestionResponseDtos.get(i));
                        questionsOfExamDtos.add(i, questionsOfExamDto);
                    }
                    resultStudentExamService.save(resultStudentExam);
                    return questionsOfExamDtos;
                } else return null;
            }else return null;
    }
    @PostMapping("/studentAnswerExam")
    public void studentAnswerExam (@RequestParam Long id,@RequestBody List<StudentAnswerQuestionDto> studentAnswerQuestionDto){

        Student student=studentService.findById(id).get();
        ResultStudentExam resultStudentExam=resultStudentExamService.findByStudent(student);
        if (LocalTime.now().isBefore(resultStudentExam.getTime())) {
            for (int i = 0; i < studentAnswerQuestionDto.size(); i++) {
                StudentAnswerQuestionDto studentAnswerQuestionDto2 = studentAnswerQuestionDto.get(i);
                if (studentAnswerQuestionDto2.getAnswerTestQuestion() != null) {
                    MultipleChoice multipleChoice = multipleChoiceService.findById(studentAnswerQuestionDto2.getAnswerTestQuestion()).get();
                    StudentAnswerTestQuestion studentAnswerTestQuestion =
                            new StudentAnswerTestQuestion(testQuestionService.findById(studentAnswerQuestionDto2.getIdQuestion()).get(),
                                    student, multipleChoice);
                    studentAnswerTestQuestionService.save(studentAnswerTestQuestion);
                } else if (studentAnswerQuestionDto2.getAnswerTestQuestion()==null) {

                    DescriptiveQuestion descriptiveQuestion = descriptiveQuestionService.findById(studentAnswerQuestionDto2.getIdQuestion()).get();
                    StudentAnswerDescriptiveQuestion studentAnswerDescriptiveQuestion =
                            new StudentAnswerDescriptiveQuestion(descriptiveQuestion,
                                    student,
                                    studentAnswerQuestionDto2.getAnswerDescriptiveQuestion());

                    studentAnswerDescriptiveQuestionService.save(studentAnswerDescriptiveQuestion);
                }
            }
            resultStudentExam.setExamStatus(ExamStatus.DONE);
            resultStudentExamService.save(resultStudentExam);
        }
    }
}
