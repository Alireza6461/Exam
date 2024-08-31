package com.project.azmoon.service.Impl;

import com.project.azmoon.base.service.Impl.BaseEntityServiceImpl;
import com.project.azmoon.domain.User;
import com.project.azmoon.repository.UserRepository;
import com.project.azmoon.service.UserService;
import com.project.azmoon.service.dto.searchdto.UserSearch;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl <T extends User, R extends UserRepository<T>> extends BaseEntityServiceImpl<T, Long, R>
        implements UserService<T> {
    public UserServiceImpl(R repository) {
        super(repository);
    }

    @Override
    public T findByUsername(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public List<T> findAll(UserSearch userSearch) {
        return repository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            setFirstName(predicates, root, criteriaBuilder, userSearch.getFirstName());
            setLastName(predicates, root, criteriaBuilder, userSearch.getLastName());
            setRole(predicates, root, criteriaBuilder, userSearch.getRole());
            return criteriaBuilder.and(
                    predicates.toArray(new Predicate[0])
            );
        });
    }
    private void setFirstName(List<Predicate> predicates, Root<T> root,
                              CriteriaBuilder criteriaBuilder, String firstName) {
        if (firstName!=null && !firstName.isBlank()){
            predicates.add(
                    criteriaBuilder.like(
                            root.get("lastName"),
                            "%" + firstName + "%"
                    )
            );
        }
    }

    private void setLastName(List<Predicate> predicates, Root<T> root,
                             CriteriaBuilder criteriaBuilder, String lastName) {
        if (lastName!=null && !lastName.isBlank()){
            predicates.add(
                    criteriaBuilder.like(
                            root.get("lastName"),
                            "%" + lastName + "%"
                    )
            );
        }
    }

    private void setRole(List<Predicate> predicates, Root<T> root,
                         CriteriaBuilder criteriaBuilder, String role) {
        if (role!=null && !role.isBlank()){
            predicates.add(
                    criteriaBuilder.equal(
                            root.get("role"),role
                    )
            );
        }
    }
}
