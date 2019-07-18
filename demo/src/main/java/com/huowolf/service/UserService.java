package com.huowolf.service;

import com.huowolf.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    User save(User user);
    List<User> findAll();
    void delete(Integer id);

    void enable(Integer id);
}
