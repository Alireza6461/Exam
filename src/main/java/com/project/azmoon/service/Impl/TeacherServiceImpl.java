package com.project.azmoon.service.Impl;

import com.project.azmoon.domain.Student;
import com.project.azmoon.domain.Teacher;
import com.project.azmoon.repository.TeacherRepository;
import com.project.azmoon.repository.UserRepository;
import com.project.azmoon.service.TeacherService;
import com.project.azmoon.util.RandomUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class TeacherServiceImpl extends UserServiceImpl<Teacher, TeacherRepository> implements TeacherService {

    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }
    @Override
    public Teacher save(Teacher teacher) {
        setTeacherCode(teacher);
        return repository.save(teacher);
    }
    public void setTeacherCode(Teacher teacher) {
        String entranceYear = String.valueOf(new Date().getYear());
        String teacherCode = entranceYear.concat(RandomUtil.getRandomNumeric(6));
        while (repository.existsByTeacherCode(teacherCode)) {
            teacherCode = entranceYear.concat(RandomUtil.getRandomNumeric(6));
        }
        teacher.setTeacherCode(teacherCode);
    }

    @Override
    public List<Teacher> findByIsActiveFalse() {
        return repository.findByIsActiveFalse();
    }

    @Override
    public List<Teacher> findByIsActiveTrue() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public Teacher findByTeacherCode(String teacherCode) {
        return repository.findByTeacherCode(teacherCode);
    }
}
