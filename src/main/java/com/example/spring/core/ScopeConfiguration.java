package com.example.spring.core;

import com.example.spring.core.data.Bar;
import com.example.spring.core.data.Foo;
import com.example.spring.core.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Slf4j
public class ScopeConfiguration {
    @Bean
    @Scope("prototype")
    public Foo foo(){
        log.info("create new foo");
        return new Foo();
    }

    //berguna untuk mendaftarkan custom scope yang sudah dibuat
    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar(){
        log.info("Create new bar");
        return new Bar();
    }
}
