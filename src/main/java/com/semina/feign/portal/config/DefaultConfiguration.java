package com.semina.feign.portal.config;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DefaultConfiguration {

    private final DefaultOkHttpInterceptor okHttpInterceptor;

    @Bean
    public OkHttpClient.Builder okHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .addInterceptor(okHttpInterceptor);
    }

}
