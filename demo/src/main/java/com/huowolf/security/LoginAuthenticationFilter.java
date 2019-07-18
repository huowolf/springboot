package com.huowolf.security;

import com.google.code.kaptcha.Constants;
import com.huowolf.exception.CaptchaException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huowolf on 2018/1/31.
 * 自定义认证过滤器
 */
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //获取表单提交的验证码的值
        String verification = request.getParameter("code");
        //获取下发的存在session中的验证码的值
        String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (captcha==null){
            throw new CaptchaException("验证码不为空");
        }
        else  if (!captcha.contentEquals(verification)) {
            throw new CaptchaException("验证码不匹配");
        }
        return super.attemptAuthentication(request, response);
    }
}
