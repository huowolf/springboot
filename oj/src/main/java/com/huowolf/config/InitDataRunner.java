package com.huowolf.config;

import com.huowolf.domain.User;
import com.huowolf.repository.UserRepository;
import com.huowolf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by huowolf on 2018/1/29.
 */
@Component
public class InitDataRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("初始化系统数据");

        long number = userRepository.count();
        if(number == 0){
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setEmail("xxxxx@qq.com");
            user.setRole("ADMIN");
            userService.save(user);
        }

    }
}
