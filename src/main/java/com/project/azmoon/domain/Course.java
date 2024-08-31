package com.project.azmoon.domain;

import com.project.azmoon.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;


@Setter
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Course extends BaseEntity<Long> {

    private String title;

    private LocalDate dateOfStart;

    private LocalDate dateOfFinish;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<StudentCourses> studentCourses;

     @OneToMany(mappedBy = "course")
     private List<Exam> exams;


}
