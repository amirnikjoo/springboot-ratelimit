package com.efarda.service.impl;

import com.efarda.domain.User;
import com.efarda.exception.DataNotFound;
import com.efarda.repository.UserRepository;
import com.efarda.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User dto) throws DataNotFound {
//        throw new DataNotFound("this is a test exception", dto.toString());
        log.info("current thread: {}", Thread.currentThread());
        User user1 = new User();
        user1.setName(dto.getName());
        user1.setAge(dto.getAge());
        userRepository.save(user1);
        log.info("active thread: {}", Thread.activeCount());
    }

    @Override
    public List<User> allUsers() {
        return (List<User>) userRepository.findAll();
    }
}
