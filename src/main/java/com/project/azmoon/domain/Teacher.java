package com.project.azmoon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher extends User {

    @Column
    private String teacherCode;

    @Column
    private String email;

    @Column
    private String mobileNumber;

    @OneToMany(mappedBy = "teacher")
    private List<Course> course;

    @OneToMany(mappedBy = "teacher")
    private List<DescriptiveQuestion> descriptiveQuestions;

    @OneToMany(mappedBy = "teacher")
    private List<TestQuestion> testQuestions;


}
