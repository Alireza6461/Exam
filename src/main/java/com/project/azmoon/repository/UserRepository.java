package com.project.azmoon.repository;


import com.project.azmoon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T, Long>,
        JpaSpecificationExecutor<T> {

    T findByUserName(String userName);

    <P> List<P> findByRole(String Role, Class<P> pClass);
}
