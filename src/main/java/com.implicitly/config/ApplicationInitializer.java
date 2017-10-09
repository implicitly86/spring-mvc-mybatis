package com.implicitly.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author EMurzakaev@it.ru.
 */
public final class ApplicationInitializer implements WebApplicationInitializer {

    /**
     * Экземпляр логгера.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInitializer.class);

    /**
     *
     */
    public void onStartup(ServletContext servletCxt) throws ServletException {
        LOGGER.info("Configure servlet");
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        //ctx.setServletContext(container);
        final DispatcherServlet servlet = new DispatcherServlet(ctx);
        final ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }

}
