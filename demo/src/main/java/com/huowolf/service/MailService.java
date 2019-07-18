package com.huowolf.service;

/**
 * Created by huowolf on 2018/2/3.
 */
public interface MailService {

    /**
     *
     * @param to        接收方
     * @param subject   主题
     * @param context   内容
     */
    public void sendHtmlMail(String to,String subject,String context);
}
