package com.napt.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by napt2017 on 4/6/2017.
 */
@Configuration
@ComponentScan(basePackages = {"com.napt"},
excludeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION,value = EnableWebMvc.class)
})
public class RootConfig {
}
