package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Teacher;
import com.project.azmoon.repository.CourseRepository;
import com.project.azmoon.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl extends BaseEntityServiceImpl<Course,Long, CourseRepository> implements CourseService {
    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }

    @Override
    public List<Course> findByTeacher(Teacher teacher) {
        return repository.findByTeacher(teacher);
    }
}
