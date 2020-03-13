package spring.boot.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Created 09 / 03 / 2020 - 5:19 PM
 * @project SpringData
 * @Author Hamdamboy
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
