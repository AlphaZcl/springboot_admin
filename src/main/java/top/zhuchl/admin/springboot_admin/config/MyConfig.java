package top.zhuchl.admin.springboot_admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.zhuchl.admin.springboot_admin.interceptor.LoginInterceptor;

/**
 * @Author AlphaZcl
 * @Date 2021/10/28
 **/
@Configuration
public class MyConfig {

    @Bean("webMvcConfigurer")
    public WebMvcConfigurer getWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")//所有请求都会被拦截，包括静态资源
                        .excludePathPatterns("/", "/signIn","/querySql","/js/**","/css/**","/images/**","/fonts/**","/error/**");
            }
        };
    }
}
