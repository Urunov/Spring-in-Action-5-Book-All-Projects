package spring.security.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * @Created 17 / 03 / 2020 - 6:43 PM
 * @project BootSecure
 * @Author Hamdamboy
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    //
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/abc").setViewName("home");
        registry.addViewController("/login");
    }
}
