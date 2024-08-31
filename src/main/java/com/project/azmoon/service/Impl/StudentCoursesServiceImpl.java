package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.Course;
import com.project.azmoon.domain.Student;
import com.project.azmoon.domain.StudentCourses;
import com.project.azmoon.repository.StudentCoursesRepository;
import com.project.azmoon.repository.StudentRepository;
import com.project.azmoon.service.StudentCoursesService;
import com.project.azmoon.service.StudentService;
import com.project.azmoon.service.dto.searchdto.UserSearch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentCoursesServiceImpl extends BaseEntityServiceImpl<StudentCourses,Long, StudentCoursesRepository> implements StudentCoursesService {

    public StudentCoursesServiceImpl(StudentCoursesRepository repository) {
        super(repository);
    }

    @Override
    public List<StudentCourses> findByCourse(Course course) {
        return repository.findByCourse(course);
    }
}
