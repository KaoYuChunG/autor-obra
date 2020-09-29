package com.teste.autor.config;


import com.teste.autor.modules.repository.app.AutorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = AutorRepository.class,
        entityManagerFactoryRef = "appEbtityManager")
public class AppDb {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource appDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean appEbtityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("appDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.teste.autor.modules.model.app")
                .build();
    }
}
