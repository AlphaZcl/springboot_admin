package top.zhuchl.admin.springboot_admin.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.zhuchl.admin.springboot_admin.interceptor.LoginInterceptor;

/**
 * 完全取代SpringMVC配置
 *
 * @EnableWebMvc + WebMvcConfigurer
 *
 * @Author AlphaZcl
 * @Date 2021/11/2
 **/
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/*").addResourceLocations("classpath:/static");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//所有请求都会被拦截，包括静态资源
                .excludePathPatterns("/", "/signIn","/js/**","/css/**","/images/**","/fonts/**","/error/**");
    }
}
