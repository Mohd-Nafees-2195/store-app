package com.shophub.store_app.config.fakestoreconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FakeStoreConfig {

    @Bean
    public RestTemplate restTemplateBeen(){
        return new RestTemplate();
    }
}
