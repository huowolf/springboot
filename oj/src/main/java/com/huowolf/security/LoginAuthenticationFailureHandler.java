package com.huowolf.security;

import com.huowolf.exception.CaptchaException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huowolf on 2018/1/31.
 * 登陆失败处理器
 */
public class LoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

    private static final String PASS_ERROR_URL = "/login?error";
    private static final String KAPTCHA_ERROR_URL = "/login?kaptcha";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        if(exception instanceof CaptchaException){
            getRedirectStrategy().sendRedirect(request,response,KAPTCHA_ERROR_URL);
        }else{
            getRedirectStrategy().sendRedirect(request,response,PASS_ERROR_URL);
        }
        //super.onAuthenticationFailure(request, response, exception);
    }
}
