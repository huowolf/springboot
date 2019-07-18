package com.huowolf.until;

import com.huowolf.config.MailConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huowolf on 2018/2/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private MailConfig mailConfig;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void mailConfigTest(){
       String enableUrl = mailConfig.getEnableUrl();
       logger.info(enableUrl);
    }
}
