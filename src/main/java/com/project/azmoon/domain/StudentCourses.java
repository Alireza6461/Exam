package com.project.azmoon.domain;

import com.project.azmoon.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourses extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn
    private Course course;

    @ManyToOne
    @JoinColumn
    private Student student;
}
