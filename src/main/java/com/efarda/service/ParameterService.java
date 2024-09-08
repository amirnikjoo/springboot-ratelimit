package com.efarda.service;

import com.efarda.domain.Parameter;
import com.efarda.domain.User;
import com.efarda.exception.DataNotFound;

import java.util.List;
import java.util.Map;

public interface ParameterService {
    List<Parameter> getParameterByGroupId(Long groupId);

    Parameter getParameterById(Long id);

    Map<Long, Parameter> getParameterMap(Long GroupId);
}
