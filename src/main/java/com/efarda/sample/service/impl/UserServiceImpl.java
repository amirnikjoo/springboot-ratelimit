package com.efarda.sample.service.impl;

import com.efarda.sample.dto.UserDto;
import com.efarda.sample.exception.DataNotFound;
import com.efarda.sample.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final List<UserDto> users = new ArrayList<>();

    @Override
    public void addUser(UserDto user) throws DataNotFound {
        throw new DataNotFound("this is a test exception", user.toString());
//        users.add(user);
    }

    @Override
    public List<UserDto> allUsers() {
        return users;
    }
}
