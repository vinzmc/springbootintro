package com.example.spring.core;

import com.example.spring.core.data.Bar;
import com.example.spring.core.data.Foo;
import com.example.spring.core.data.FooBar;
import org.springframework.context.annotation.Bean;

public class DependencyInjectionConfiguration {
    @Bean
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public FooBar fooBar(Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }
}
