package com.huowolf.service.impl;

import com.huowolf.domain.User;
import com.huowolf.repository.UserRepository;
import com.huowolf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
