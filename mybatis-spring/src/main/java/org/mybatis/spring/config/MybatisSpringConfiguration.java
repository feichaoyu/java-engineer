package org.mybatis.spring.config;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan("org.mybatis.spring.mapper")
public class MybatisSpringConfiguration {

//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//        return new SqlSessionFactoryBuilder().build(reader);
//    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("mybatis-config.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("org.mybatis.spring.model");
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        UnpooledDataSource dataSource = new UnpooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/play-with-mybatis");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        return dataSource;
    }
}
