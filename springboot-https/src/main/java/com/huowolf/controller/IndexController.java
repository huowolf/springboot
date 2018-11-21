package com.huowolf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huowolf on 2018/11/21.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "hello index!";
    }
}
