package com.khang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Driver;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.khang.repository")
@EnableTransactionManagement
@PropertySource("classpath:Application.properties") //Doc file trong Appliction.properties
public class JPAConfig {

   // @Autowired // tự động khởi tạo đối tượng được lưu trong bean controller - Spring core
    private Environment environment;// là gì? là biến vào file classpath dể đọc

    @Autowired
    public JPAConfig (Environment environment){
        this.environment = environment;
    }

    @Bean//kết nối mapping database vs hibernate
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource()); //kết nối database

        em.setPersistenceUnitName("persistence-data");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();// chứa hàng loat câu lệnh
        em.setJpaVendorAdapter(vendorAdapter);// chưa hàm // kêt nối table vs @Entity
        em.setJpaProperties(additionalProperties()); // mapping database vs hibernate

        return em;
    }

    public Properties additionalProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        //dialect nhận câu lệnh hiện hành

        properties.setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        //hiển thi câu lệnh sql ra console
        properties.setProperty("hibernate.default_schema", environment.getProperty("hibernate.default_schema"));
        properties.setProperty("hibernate.format_sql",environment.getProperty("hibernate.format_sql"));

        properties.setProperty("hibernate.enable_lazy_load_no_trans","true");
        properties.setProperty("hibernate.hbm2ddl.auto","create");// tạo nếu sau chạy sẽ xóa bản cũ
        //properties.setProperty("hibernate.hbm2ddl.auto","update");

        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("driverClassName")); // liên kết giữa java và database
        dataSource.setUrl(environment.getProperty("url")); //địa chỉ của database
        dataSource.setUsername(environment.getProperty("user")); //
        dataSource.setPassword(environment.getProperty("password"));

        return dataSource;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
