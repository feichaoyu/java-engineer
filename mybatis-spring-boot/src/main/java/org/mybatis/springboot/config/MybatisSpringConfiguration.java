package org.mybatis.springboot.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Reader;

@Configuration
public class MybatisSpringConfiguration {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(reader);
    }
}
