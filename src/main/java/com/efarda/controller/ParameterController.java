package com.efarda.controller;

import com.efarda.domain.Parameter;
import com.efarda.domain.User;
import com.efarda.exception.DataNotFound;
import com.efarda.service.ParameterService;
import com.efarda.service.UserService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

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

    @GetMapping("/{id}")
    Parameter getParametersById(@PathVariable("id") Long id) {
        return parameterService.getParameterById(id);
    }

}