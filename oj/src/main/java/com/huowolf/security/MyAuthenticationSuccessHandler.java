package com.huowolf.security;

import com.huowolf.domain.User;
import com.huowolf.repository.UserRepository;
import com.huowolf.until.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    private final static Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        User user = (User) authentication.getPrincipal();

        String ip = IPUtil.getIpAddress(request);
        logger.info("{}的ip：{}",user.getUsername(),ip);

        user.setLastLoginTime(new Date());
        userRepository.save(user);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
