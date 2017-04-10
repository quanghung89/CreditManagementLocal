package com.napt.spring.config;

import com.napt.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by napt2017 on 4/6/2017.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    @Autowired
    private ApplicationContext appContext;

    @Bean
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/money_interest_manager");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("147852aA@");
        return  driverManagerDataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(appContext.getBean(DriverManagerDataSource.class));
        localSessionFactoryBean.setAnnotatedClasses(
                User.class
        );

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.jdbc.batch_versioned_data","true");
        properties.put("hibernate.enable_lazy_load_no_trans","true");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }
}
