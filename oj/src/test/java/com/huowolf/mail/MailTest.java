package com.huowolf.mail;

import com.huowolf.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

/**
 * Created by huowolf on 2018/2/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailService mailService;

    @Test
    public void simpleMailTest(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("274956285@qq.com");
        message.setTo("18532032101@163.com");
        message.setSubject("测试简单邮件");
        message.setText("这是一封测试邮件");
        javaMailSender.send(message);
    }

    @Test
    public void TemplateMailTest(){
        Context context = new Context();
        context.setVariable("id","1");
        String text = templateEngine.process("registerMail",context);
        mailService.sendHtmlMail("18532032101@163.com","用户注册",text);
    }
}
