package com.batchsi.dataloader.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.batchsi.dataloader.AppDAOConfiguration;

@Configuration
@ComponentScan(basePackages = "com.batchsi.dataloader")
@Import({ AppDAOConfiguration.class })
public class AppConfiguration {

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setMessageConverters(messageConverters());
        return requestMappingHandlerAdapter;
    }

    private List<HttpMessageConverter<?>> messageConverters() {
        // MappingJackson2HttpMessageConverter
        // Jaxb2RootElementHttpMessageConverter

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(new Jaxb2RootElementHttpMessageConverter());
        return messageConverters;
    }
}
