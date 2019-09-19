package com.huowolf.snowflake.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @创建人：王小伟
 * @创建时间： 2019/9/19
 * @描述：
 */
@Configuration
public class SnowflakeConfig {

    @Bean
    public Snowflake snowflake(){
        return IdUtil.createSnowflake(1,1);
    }
}
