package com.huowolf.controller;

import com.huowolf.domain.User;
import com.huowolf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String toSaveUser(){
        return "user/saveUser";
    }

    @RequestMapping("/save")
    public String saveUser(User user){
        user.setLastLoginTime(new Date());
        userService.save(user);
        return "redirect:list";
    }

    @RequestMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable  Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user/update";
    }

    @RequestMapping("update")
    public String update(User user){
        User user1 = userService.findById(user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        userService.save(user1);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Integer id){
        userService.delete(id);
        return "redirect:list";
    }
}
