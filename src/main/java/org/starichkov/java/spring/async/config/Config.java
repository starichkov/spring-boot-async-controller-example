package org.starichkov.java.spring.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Vadim Starichkov
 * @since 07.02.2021 18:19
 */
@Configuration
@EnableAsync
public class Config {

    @Bean
    public ThreadPoolTaskExecutor customTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(32);
        executor.setQueueCapacity(128);
        return executor;
    }
}
