package com.efarda.sample.service;

import com.efarda.sample.dto.UserDto;
import com.efarda.sample.exception.DataNotFound;

import java.util.List;

public interface UserService {
    void addUser(UserDto user) throws DataNotFound;
    List<UserDto> allUsers();

}
