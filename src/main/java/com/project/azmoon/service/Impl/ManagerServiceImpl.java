package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.Manager;
import com.project.azmoon.repository.ManagerRepository;
import com.project.azmoon.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerServiceImpl extends BaseEntityServiceImpl<Manager,Long, ManagerRepository> implements ManagerService {
    public ManagerServiceImpl(ManagerRepository repository) {
        super(repository);
    }

    @Override
    public Manager findByUserName(String userName) {
        return repository.findByUserName(userName);
    }
}
