package test.config;

import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@Import({ AspectConfig.class })
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> httpMessageConverters) {
		httpMessageConverters.add(new MappingJacksonHttpMessageConverter());
	}

	@Bean
	public DataSource dataSource() {
		// configure and return the necessary JDBC DataSource
		JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
		dataSource.setJndiName("java:comp/env/jdbc/test");
		try {
			dataSource.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			// rethrow
			throw new RuntimeException(e);
		} catch (NamingException e) {
			// rethrow
			throw new RuntimeException(e);
		}
		return (DataSource) dataSource.getObject();
	}

	@Bean
	public DataSourceTransactionManager txManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}

}
