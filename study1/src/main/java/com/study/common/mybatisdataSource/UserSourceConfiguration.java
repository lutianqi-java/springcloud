package com.study.common.mybatisdataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.study.user", sqlSessionTemplateRef = "userSqlSessionTemplate")
public class UserSourceConfiguration {

    @Value("${spring.datasource.test1.type}")
    private String sourceType;

    @Value("${spring.datasource.test1.url}")
    private String url;

    @Value("${spring.datasource.test1.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.test1.username}")
    private String username;

    @Value("${spring.datasource.test1.password}")
    private String password;

    /**
     * 配置数据源
     *
     * @return
     */
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource userDataSource() throws ClassNotFoundException {
//        return DataSourceBuilder.create().build();
        Class<? extends DataSource> dataSourceType;
        dataSourceType = (Class<? extends DataSource>) Class.forName(sourceType);
        DataSourceBuilder factory = DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .type(dataSourceType);
        return factory.build();
    }

    /**
     * 配置会话工厂
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/user/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 事物管理器
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager userTransactionManager(@Qualifier("userDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
