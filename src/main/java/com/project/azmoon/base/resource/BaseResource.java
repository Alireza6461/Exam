package com.project.azmoon.base.resource;

import com.project.azmoon.base.domain.BaseEntity;
import com.project.azmoon.base.dto.BaseDto;
import com.project.azmoon.base.exception.BadRequestRuntimeException;
import com.project.azmoon.base.exception.EntityNotFoundRuntimeException;
import com.project.azmoon.base.mapper.BaseMapper;
import com.project.azmoon.base.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;


@RequiredArgsConstructor
public class BaseResource <E extends BaseEntity<ID>,
        D extends BaseDto<ID>,
        ID extends Serializable,
        S extends BaseEntityService<E, ID>,
        M extends BaseMapper<E, D, ID>> {

    protected final S service;

    protected final M mapper;

    @GetMapping
    public ResponseEntity<D> getById(@RequestParam ID id) {
        Optional<E> optional = service.findById(id);
        return ResponseEntity.ok(
                mapper.convertEntityToDTO(
                        optional.orElseThrow(
                                () -> new EntityNotFoundRuntimeException("not found")
                        )
                )
        );
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody D d) {
        if (d.getId() == null) {
            throw new BadRequestRuntimeException(
                    "id must be null"
            );
        }
        E e = service.save(
                mapper.convertDTOToEntity(d)
        );
        return ResponseEntity.ok(mapper.convertEntityToDTO(e));
    }

    @PutMapping
    public ResponseEntity<D> update(@RequestBody D d) {
        if (d.getId() == null) {
            throw new BadRequestRuntimeException(
                    "id must not be null"
            );
        }
        E e = service.save(
                mapper.convertDTOToEntity(d)
        );
        return ResponseEntity.ok(mapper.convertEntityToDTO(e));
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<D>> getPage(Pageable pageable) {
        Page<E> page = service.findAll(pageable);
        return ResponseEntity.ok(
                page.map(mapper::convertEntityToDTO)
        );
    }
}
