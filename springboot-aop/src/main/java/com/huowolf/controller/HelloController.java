package com.huowolf.controller;

/**
 * @author huowolf
 * @date 2019/7/18
 * @description
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name, int state) {
        return "name " + name + "---" + state;
    }

}