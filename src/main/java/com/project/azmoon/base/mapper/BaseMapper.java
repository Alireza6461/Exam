package com.project.azmoon.base.mapper;

import com.project.azmoon.base.domain.BaseEntity;
import com.project.azmoon.base.dto.BaseDto;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper <E extends BaseEntity<ID>, D extends BaseDto<ID>, ID extends Serializable>{

    E convertDTOToEntity(D d);
    D convertEntityToDTO(E e);

    List<E> convertListDTOToEntityList(List<D> dtoList);

    List<D> convertEntityListToDTOList(List<E> entityList);
}
