package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.Manager;

public interface ManagerService extends BaseEntityService<Manager,Long> {

    Manager findByUserName(String userName);
}
