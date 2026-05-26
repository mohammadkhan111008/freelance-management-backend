package com.codingshuttle.codingshuttleRESTAPI.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // - Indicates that this is a configuuration class in which we will be making different ypes of beans and we can also write different configuration related code in this class.
public class MapperConfig {
    

    @Bean // - Indicates that this method will return a bean that should be managed by the Spring container. A bean is an object that is instantiated, assembled, and managed by the Spring IoC (Inversion of Control) container. By annotating a method with @Bean, you are telling Spring to execute that method and register the returned object as a bean in the application context.
    public ModelMapper modelMapper(){
        return new ModelMapper(); // - This line creates and returns a new instance of the ModelMapper class. ModelMapper is a library that helps in mapping objects of one type to another, often used for converting between DTOs (Data Transfer Objects) and entities in Java applications. By defining this method as a bean, you can inject the ModelMapper instance into other components of your application where you need to perform object mapping.
        
    }

}
