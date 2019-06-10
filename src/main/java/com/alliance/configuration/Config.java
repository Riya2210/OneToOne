package com.alliance.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * @author Riya
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.alliance")
public class Config {

	@Value("${mpfp.db.write.driver}")
	private String driverClass;
	@Value("${mpfp.db.write.url}")
	private String url;
	@Value("${mpfp.db.write.username}")
	private String userName;
	@Value("${mpfp.db.write.password}")
	private String password;
	@Value("${hibernate.show_sql}")
	private String show_Sql;
	@Value("${hibernate.dialect}")
	private String dialect;

	@Bean
	public DataSource dataSource() {
		System.out.println("Environment: " + System.getProperty("server.env"));
		DriverManagerDataSource dataSource = null;
		try {
			dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(driverClass);
			dataSource.setUrl(url);
			dataSource.setUsername(userName);
			dataSource.setPassword(password);
		} catch (Exception e) {
			System.out.println("Exception occurred in dataSource bean configuration: " + e.getMessage());
		}
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = null;
		try {
			sessionFactoryBean = new LocalSessionFactoryBean();
			sessionFactoryBean.setDataSource(dataSource());
			Properties hibernateProperties = new Properties();
			hibernateProperties.put("hibernate.dialect", dialect);
			hibernateProperties.put("hibernate.hbm2ddl.auto", "none");
			hibernateProperties.put("hibernate.show_sql", show_Sql);
			sessionFactoryBean.setHibernateProperties(hibernateProperties);
			sessionFactoryBean.setPackagesToScan(new String[] { "com.alliance" });
			return sessionFactoryBean;
		} catch (Exception e) {
			System.out.println("Exception occurred in getSessionFactory bean configuration: " + e.getMessage());
		}
		return sessionFactoryBean;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = null;
		try {
			txManager = new HibernateTransactionManager();
			txManager.setSessionFactory(sessionFactory);
		} catch (Exception e) {
			System.out.println("Exception occurred in transactionManager bean configuration: " + e.getMessage());
		}
		return txManager;
	}

}
