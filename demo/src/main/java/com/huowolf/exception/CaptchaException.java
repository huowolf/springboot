package com.huowolf.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by huowolf on 2018/1/31.
 */
public class CaptchaException extends AuthenticationServiceException {

    public CaptchaException(String msg) {
        super(msg);
    }
}


