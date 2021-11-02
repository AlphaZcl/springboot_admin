package top.zhuchl.admin.springboot_admin.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.zhuchl.admin.springboot_admin.filter.MyFilter;
import top.zhuchl.admin.springboot_admin.listener.MyServletContextListener;
import top.zhuchl.admin.springboot_admin.servlet.MyServlet;

import java.util.Arrays;

/**
 * 原生api注册，bean注册配置
 *
 * @Author AlphaZcl
 * @Date 2021/11/2
 **/
@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        return new ServletRegistrationBean(new MyServlet(), "/myRegUrl");
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter(){
//        return new FilterRegistrationBean<>(new MyFilter(),myServlet());
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/myRegUrl","/js/*"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyServletContextListener> myListener(){
        return new ServletListenerRegistrationBean<>(new MyServletContextListener());
    }
}
