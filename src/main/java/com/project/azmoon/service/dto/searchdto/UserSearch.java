package com.project.azmoon.service.dto.searchdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSearch {

    private String firstName;

    private String lastName;

    private String Role;
}
