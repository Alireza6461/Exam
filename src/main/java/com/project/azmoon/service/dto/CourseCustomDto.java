package com.project.azmoon.service.dto;

import com.project.azmoon.base.dto.BaseDto;
import com.project.azmoon.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseCustomDto extends BaseDto<Long> {

    private String title;

    private LocalDate dateOfStart;

    private LocalDate dateOfFinish;

    private TeacherCustomDto teacher;
}
