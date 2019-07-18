package com.huowolf.controller;

import com.huowolf.config.MailConfig;
import com.huowolf.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;


@Controller
public class loginController {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailService mailService;

    @Autowired
    private MailConfig mailConfig;

    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping("/register")
    public String register(){
        Context context = new Context();
        Map<String,Object> model = new HashMap<>();
        model.put("id",1);
        model.put("enableUrl",mailConfig.getEnableUrl());
        context.setVariables(model);
        String text = templateEngine.process("registerMail",context);
        mailService.sendHtmlMail("18532032101@163.com","用户注册",text);
        return "redirect:/";
    }

}
