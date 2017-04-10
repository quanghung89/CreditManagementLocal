package com.napt.spring.config;

        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by napt2017 on 4/6/2017.
 */
@EnableWebMvc
@ComponentScan("com.napt.spring.*")
public class WebConfig {
}
