package com.huowolf.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by huowolf on 2018/1/29.
 * 该类已弃用，通过Spring jdbc的方式初始化数据。
 * 使用schema.sql和data.sql文件提供数据库定义文件和初始化数据
 */
@Deprecated
@Component
public class InitDataRunner implements CommandLineRunner {

/*  @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;*/

    @Override
    public void run(String... strings) throws Exception {
/*        System.out.println("初始化系统数据");

        long number = userRepository.count();
        if(number == 0){
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setEmail("xxxxx@qq.com");
            user.setRole("ADMIN");
            userService.save(user);
        }*/
    }
}
