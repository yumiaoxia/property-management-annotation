package com.example.property.management.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebMvcApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override

    protected Class<?>[] getRootConfigClasses() {
        return new Class[0] ;

    }



    @Override

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringMvcConfig.class };

    }



    @Override

    protected String[] getServletMappings() {
        return new String[] { "/" };

    }
}
