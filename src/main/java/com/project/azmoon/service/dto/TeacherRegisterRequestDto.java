package com.project.azmoon.service.dto;


import com.project.azmoon.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRegisterRequestDto extends BaseDto<Long> {

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String mobileNumber;

    private String email;
}
