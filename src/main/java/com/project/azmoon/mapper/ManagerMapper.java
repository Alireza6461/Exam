package com.project.azmoon.mapper;

import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.domain.Manager;
import com.project.azmoon.service.dto.PrincipalRegisterRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface ManagerMapper extends BaseMapper<Manager, PrincipalRegisterRequestDto,Long> {
}
