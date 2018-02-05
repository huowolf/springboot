package com.huowolf.service.impl;

import com.huowolf.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by huowolf on 2018/2/3.
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendHtmlMail(String to, String subject, String context) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"UTF-8");
        try {
            //logger.info("from:"+from);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(context,true);
            mailSender.send(mimeMessage);
            logger.info("邮件发送成功！");
        } catch (MessagingException e) {
            logger.error("邮件发送失败",e);
        }
    }
}
