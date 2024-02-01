package com.example.crm.bean;

import com.example.crm.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "zhangning")
    public Student getStudent1(){
        return new Student("zhangning","6","123@outlook.com",4000);
    }

    @Bean(name = "allen")
    public Student getStudent2(){
        return new Student("allen","7","456@outlook.com",4000);
    }
}
