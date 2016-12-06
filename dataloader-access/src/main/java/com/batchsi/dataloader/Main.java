package com.batchsi.dataloader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.batchsi.dataloader.entities.Parameter;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppDAOConfiguration.class);
        SessionFactory sessionFactory = applicationContext.getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();

        Parameter parameter = (Parameter) session.get(Parameter.class, 28L);
        if (parameter != null) {
            System.out.println(parameter.getDescription());
        }
        session.disconnect();
        session.close();
        ((AbstractApplicationContext) applicationContext).close();

    }
}
