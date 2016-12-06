package com.batchsi.dataloader;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.batchsi.dataloader.entities.Parameter;

@Configuration
public class AppDAOConfiguration {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan(new String[] { "com.websystique.spring.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setAnnotatedClasses(Parameter.class);
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.format_sql", "false");
        properties.put("hibernate.connection.url", "jdbc:mysql://10.170.225.30:10006/psim01");
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.username", "psim01update");
        properties.put("hibernate.connection.password", "psim01update");
        return properties;
    }
    /*
     * @Bean public SessionFactory sessionFactory() {
     * org.hibernate.cfg.Configuration configuration = new
     * org.hibernate.cfg.Configuration(); configuration.configure();
     * 
     * ServiceRegistry serviceRegistry = new
     * StandardServiceRegistryBuilder().applySettings(
     * configuration.getProperties()).build(); SessionFactory sessionFactory =
     * configuration.buildSessionFactory(serviceRegistry);
     * 
     * return sessionFactory;
     * 
     * // return null; // return new //
     * org.hibernate.cfg.Configuration().configure().buildSessionFactory(); }
     */

}
