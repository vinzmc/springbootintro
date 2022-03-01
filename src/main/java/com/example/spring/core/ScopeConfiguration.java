package com.example.spring.core;

import com.example.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
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
}
