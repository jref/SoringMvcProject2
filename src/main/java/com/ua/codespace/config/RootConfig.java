package com.ua.codespace.config;

import com.ua.codespace.service.MessageService;
import com.ua.codespace.service.impl.MessageServiceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages = {"com.ua.codespace"},
        excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
@PropertySource("classpath:/application.properties")
public class RootConfig {

    @Bean
    @Profile("dev")
    public MessageService devMessageService() {
        return new MessageServiceProvider("Hello from Dev Profile");
    }

    @Bean
    @Profile("test")
    public MessageService testMessageService() {
        return new MessageServiceProvider("Hello from test Profile");
    }

}
