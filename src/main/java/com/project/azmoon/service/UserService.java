package com.project.azmoon.service;

import com.project.azmoon.base.service.BaseEntityService;
import com.project.azmoon.domain.User;
import com.project.azmoon.service.dto.searchdto.UserSearch;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService<T extends User> extends BaseEntityService<T, Long> {

    T findByUsername(String username);

    List<T> findAll(UserSearch userSearch);

}
