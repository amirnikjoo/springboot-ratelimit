package com.efarda.repository;

import com.efarda.domain.Parameter;
import org.springframework.data.repository.CrudRepository;

public interface ParameterRepository extends CrudRepository<Parameter, Long> {

    Iterable<Parameter> findAllByGroupId(Long groupId);
}

