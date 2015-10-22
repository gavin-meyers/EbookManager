package com.github.gavinmeyers.ebookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class EbookmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbookmanagerApplication.class, args);
    }
    
    @Bean
    //@Order(Ordered.HIGHEST_PRECEDENCE)
    public StartupRunner schedulerRunner() {
      return new StartupRunner();
    }
}
