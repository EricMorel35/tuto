package com.batchsi.dataloader.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure().buildSessionFactory();
            /*
             * AnnotationConfiguration config = new AnnotationConfiguration();
             * Properties properties = new Properties();
             * properties.put("hibernate.dialect",
             * "org.hibernate.dialect.MySQLDialect");
             * properties.put("hibernate.hbm2ddl.auto", "read");
             * properties.put("hibernate.show_sql", "true");
             * properties.put("hibernate.connection.driver_class",
             * "com.mysql.jdbc.Driver");
             * properties.put("hibernate.connection.url",
             * "jdbc:mysql://10.170.225.30:10006/psim01");
             * properties.put("hibernate.connection.username", "psim01update");
             * properties.put("hibernate.connection.password", "psim01update");
             * config.addAnnotatedClass(Parameter.class);
             * 
             * return config.buildSessionFactory();
             */
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
