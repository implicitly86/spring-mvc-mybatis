package com.implicitly.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author EMurzakaev@it.ru.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.implicitly")
public class WebConfig implements WebMvcConfigurer {

    /**
     * Экземпляр логгера.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    /**
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info("Add resource handler");
        registry.addResourceHandler("/resources/**").addResourceLocations("/dist/").setCachePeriod(31556926);
    }

    /**
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        LOGGER.info("Configure default servlet handling");
        configurer.enable();
    }

    /**
     * @return
     */
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        LOGGER.info("Setup view resolver");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix("");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /**
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }

}
