package com.huowolf.controller;

import com.huowolf.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Controller
public class loginController {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailService mailService;

    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping("/register")
    public String register(){
        Context context = new Context();
        context.setVariable("id","1");
        String text = templateEngine.process("registerMail",context);
        mailService.sendHtmlMail("18532032101@163.com","用户注册",text);
        return "redirect:/";
    }

}
