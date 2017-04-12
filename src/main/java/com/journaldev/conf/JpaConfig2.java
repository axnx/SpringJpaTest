package com.journaldev.conf;

import java.sql.Driver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("core.repository")
@EnableTransactionManagement
@EnableCaching
public class JpaConfig2 {

@Value("${db.jdbcURL}")
private String jdbcURL;

@Value("${db.user}")
private String user;

@Value("${db.password}")
private String password;

@Value("${db.generateDDL}")
private Boolean generateDDL;

@SuppressWarnings("Duplicates")
@Bean
public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(Driver.class.getName());
    dataSource.setUrl("jdbc:mysql://localhost:3306/movierentaldb");
    dataSource.setUsername(System.getProperty("root"));
    dataSource.setPassword(System.getProperty("mdie1767"));
    dataSource.setInitialSize(2);
    dataSource.setMaxActive(5);
    return dataSource;
}

@Bean
public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setDatabase(Database.MYSQL);
    vendorAdapter.setGenerateDdl(generateDDL);
    vendorAdapter.setShowSql(true);

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

    factory.setJpaVendorAdapter(vendorAdapter);

    factory.setPackagesToScan("core.model");

    factory.setDataSource(dataSource());

    factory.afterPropertiesSet();
    return factory;
}

@Bean
public EntityManagerFactory entityManagerFactory(){
    return localContainerEntityManagerFactoryBean().getObject();
}



@Bean
public EntityManager entityManager(){
    return entityManagerFactory().createEntityManager();
}

@Bean
PlatformTransactionManager transactionManager(){
    JpaTransactionManager manager = new JpaTransactionManager();
    manager.setEntityManagerFactory(entityManagerFactory());
    return manager;
}

@Bean
public HibernateExceptionTranslator hibernateExceptionTranslator(){
    return  new HibernateExceptionTranslator();
}

//@Bean
//public CacheManager cacheManager(){
//    GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
//    guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterAccess(2, TimeUnit.HOURS));
//    return guavaCacheManager;
//}
}