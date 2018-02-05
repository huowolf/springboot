package com.huowolf.until;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huowolf on 2018/2/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class passwordEncoder {
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void getPassword(){
        String psd = passwordEncoder.encode("admin");
        System.out.println("psd: "+psd);
    }
}
