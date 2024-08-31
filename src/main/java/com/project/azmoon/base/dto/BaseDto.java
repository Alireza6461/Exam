package com.project.azmoon.base.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseDto<ID> {
    private ID id;
}
