package com.efarda.service.impl;

import com.efarda.domain.Parameter;
import com.efarda.repository.ParameterRepository;
import com.efarda.service.ParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParameterServiceImpl implements ParameterService {
    private final ParameterRepository parameterRepository;

    public ParameterServiceImpl(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @Override
    public List<Parameter> getParameterByGroupId(Long groupId) {
        Map<Long, Parameter> parameterMap = getParameterMap(groupId);
        parameterMap.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        return (List<Parameter>) parameterRepository.findAllByGroupId(groupId);
    }

    @Override
    public Parameter getParameterById(Long id) {
        if (parameterRepository.existsById(id)) {
            return parameterRepository.findById(id).get();
        }
        return null;
    }

    @Override
    @Cacheable(value = "parameterCache", key = "#groupId")
    public Map<Long, Parameter> getParameterMap(Long groupId) {
        log.info("inside getParameterMap");
        List<Parameter> parameters = (List<Parameter>) parameterRepository.findAllByGroupId(groupId);
        return parameters.stream().collect(Collectors.toMap(Parameter::getId, p -> p));
    }

}
