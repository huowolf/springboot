package com.huowolf.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by huowolf on 2018/2/7.
 */
@Component
@ConfigurationProperties(prefix = "mail")
@PropertySource("classpath:config/mail.properties")
@Data
public class MailConfig {

    //@Value("${mail.user.enableUrl}")
    private String enableUrl;
}
