package com.example.property.management;

import com.example.property.management.config.SpringMvcConfig;
import com.example.property.management.filter.ChanelFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //扫描springmvc
        AnnotationConfigWebApplicationContext afw = new AnnotationConfigWebApplicationContext();
        afw.register(SpringMvcConfig.class);
        //添加dispatchservlet
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(afw));

        //添加映射文件路径
        springmvc.addMapping("/");

        //给springmvc添加启动时机
        springmvc.setLoadOnStartup(1);

        servletContext.addFilter("channelFilter", new ChanelFilter());

    }
}
