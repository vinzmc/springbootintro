package com.example.spring.core;

import com.example.spring.core.data.Bar;
import com.example.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DependsOnConfiguration {

//    @DependsOn
//    untuk mengenerate beans setelah beans lain di buat
//    secara default, beans dibuat dari atas kebawah
//    menggunakan anotation @DependsOn, dapat mengkonfigurasi agar
//    springboot menggenerate beans tertentu setelah beans lain ter generate terlebih dahulu
//    contohnya ini memastikan beans "bar" digenerate terlebih dahulu sebelum "foo"
//    DependsOn bisa berisi lebih dari 1 beans

//    @Lazy
//    Serupa seperti lazy loading, anotation lazy menyebabkan
//    beans baru akan di load ketika akan digunakan,
//    hal ini berguna mengingat beans akan di load pada saat awal program dijalankan
//    ketika beans sudah banyak dan kompleks, kemungkinan startup program akan lambat.

    @Lazy
    @Bean
    @DependsOn({
            "bar"
    })
    public Foo foo(){
        log.info("Create new Foo");
        return new Foo();
    }

    @Bean
    public Bar bar(){
        log.info("Create new Bar");
        return new Bar();
    }
}
