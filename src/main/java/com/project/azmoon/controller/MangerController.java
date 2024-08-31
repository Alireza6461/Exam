package com.project.azmoon.controller;


import com.project.azmoon.domain.Manager;
import com.project.azmoon.domain.Student;
import com.project.azmoon.mapper.ManagerMapper;
import com.project.azmoon.service.ManagerService;
import com.project.azmoon.service.StudentService;
import com.project.azmoon.service.dto.searchdto.ManagerResponseSearchDto;
import com.project.azmoon.service.dto.searchdto.MangerRequestSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class MangerController {

    private final ManagerService managerService;
    private final ManagerMapper managerMapper;
    private final StudentService studentService;

    @GetMapping("/login")
    public ManagerResponseSearchDto loginManger(@RequestBody MangerRequestSearch mangerRequestSearch ){

        ManagerResponseSearchDto managerResponseSearchDto=new ManagerResponseSearchDto();
        Manager manager =managerService.findByUserName(mangerRequestSearch.getUserName());
        if (mangerRequestSearch.getPassword().equals(manager.getPassword())) {

             managerResponseSearchDto.setFirstName(manager.getFirstName());
             managerResponseSearchDto.setLastName(manager.getLastName());
             return managerResponseSearchDto;
        }
        else return (ManagerResponseSearchDto) ResponseEntity.notFound();


    }


}
