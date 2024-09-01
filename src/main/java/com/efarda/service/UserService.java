package com.efarda.service;

import com.efarda.domain.User;
import com.efarda.exception.DataNotFound;

import java.util.List;

public interface UserService {
    void addUser(User user) throws DataNotFound;
    List<User> allUsers();

}
