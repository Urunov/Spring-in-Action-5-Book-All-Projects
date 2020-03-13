package jpa.spring.web;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Created 13 / 03 / 2020 - 5:03 PM
 * @project SpringJPA
 * @Author Hamdamboy
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }}
