package com.ESA.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/providehelp").setViewName("ProvideAnswer");
        registry.addViewController("/opportunities").setViewName("opportunities");
        registry.addViewController("/donation").setViewName("Donation");
        registry.addViewController("/Frontpage").setViewName("FrontPage");
        registry.addViewController("/success").setViewName("succesfully");
        registry.addViewController("/AboutUs").setViewName("AboutUs");
        // registry.addViewController("/profile").setViewName("profile");




    }

}