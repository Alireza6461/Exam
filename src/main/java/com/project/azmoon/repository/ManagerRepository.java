package com.project.azmoon.repository;

import com.project.azmoon.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long>, JpaSpecificationExecutor<Manager> {

    Manager findByUserName(String userName);
}
