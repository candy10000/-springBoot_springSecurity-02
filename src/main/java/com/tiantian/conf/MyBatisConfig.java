package com.tiantian.conf;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * 自动配置mybatis属性
 *
 */


@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    //数据库的字段可以使用book_name->bookName
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){

     return  new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
