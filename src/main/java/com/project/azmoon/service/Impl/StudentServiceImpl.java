package com.project.azmoon.service.Impl;

import com.project.azmoon.domain.Student;
import com.project.azmoon.repository.StudentRepository;
import com.project.azmoon.service.StudentService;
import com.project.azmoon.util.RandomUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class StudentServiceImpl extends UserServiceImpl<Student, StudentRepository> implements StudentService {


    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public Student save(Student student) {
        setStudentCode(student);
        return repository.save(student);
    }

    public void setStudentCode(Student student) {
        String entranceYear = String.valueOf(new Date().getYear());
        String studentCode = entranceYear.concat(RandomUtil.getRandomNumeric(6));
        while (repository.existsByStudentCode(studentCode)) {
            studentCode = entranceYear.concat(RandomUtil.getRandomNumeric(6));
        }
        student.setStudentCode(studentCode);
    }


    @Override
    public List<Student> findByIsActiveFalse() {
        return repository.findByIsActiveFalse();
    }

    @Override
    public List<Student> findByIsActiveTrue(){return repository.findByIsActiveTrue();}
}
