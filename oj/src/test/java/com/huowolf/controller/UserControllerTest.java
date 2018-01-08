package com.huowolf.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.HandlerResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    public void findAllUser() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("userList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void saveUser() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/user/save")
        .param("userName","zhangsan")
        .param("email","zhangsan@163.com")
        .param("password","zhangsan"))
                .andExpect(MockMvcResultMatchers.handler().handlerType(UserController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName("saveUser"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:list"))
                .andDo(MockMvcResultHandlers.print());
    }
}