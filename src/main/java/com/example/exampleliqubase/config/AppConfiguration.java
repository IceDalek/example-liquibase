package com.example.exampleliqubase.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
