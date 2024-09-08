package com.efarda.controller;

import com.efarda.domain.Parameter;
import com.efarda.service.ParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/parameter")
@Slf4j
class ParameterController {
    final ParameterService parameterService;

    ParameterController(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    @GetMapping("/group/{group-id}")
    List<Parameter> getParametersByGroupId(@PathVariable("group-id") Long groupId) {
        return parameterService.getParameterByGroupId(groupId);
    }

    @GetMapping("/group/cache/{group-id}")
    Map<Long, Parameter> getCacheParametersByGroupId(@PathVariable("group-id") Long groupId) {
        return parameterService.getParameterMap(groupId);
    }

    @GetMapping("/{id}")
    Parameter getParametersById(@PathVariable("id") Long id) {
        return parameterService.getParameterById(id);
    }

}