package com.huowolf.controller;

import com.huowolf.domain.User;
import com.huowolf.service.MailService;
import com.huowolf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/list")
    public String findAllUser(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "user/userList";
    }

    @RequestMapping("/toSave")
    public String toSaveUser(Model model){
        User user = new User();
        model.addAttribute("user",user);//如果不初始化，会报错。
        return "user/saveUser";
    }

    @RequestMapping("/save")
    public String saveUser(@Valid User user, BindingResult errors,Model model){
        model.addAttribute("user",user); //数据回显
        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "user/saveUser";
        }
        //user.setLastLoginTime(new Date());
        userService.save(user);
        return "redirect:list";
    }

    @RequestMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable  Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user/update";
    }

    @RequestMapping("/update")
    public String update(User user){
        User user1 = userService.findById(user.getUserId());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        userService.save(user1);
        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        userService.delete(id);
        return "redirect:list";
    }

    @RequestMapping("/enable")
    public String enable(Integer id){
        userService.enable(id);
        return "registerSuccess";
    }



}
