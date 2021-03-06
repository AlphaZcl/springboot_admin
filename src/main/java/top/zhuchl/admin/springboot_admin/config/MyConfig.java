package top.zhuchl.admin.springboot_admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.zhuchl.admin.springboot_admin.interceptor.LoginInterceptor;
import top.zhuchl.admin.springboot_admin.interceptor.RedisUrlCountInterceptor;
import top.zhuchl.admin.springboot_admin.pojo.User;

/**
 * @Author AlphaZcl
 * @Date 2021/10/28
 **/
@Configuration
@Profile("aaa")
@EnableConfigurationProperties(User.class)
public class MyConfig {

    @Autowired
    private RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Bean("webMvcConfigurer")
    public WebMvcConfigurer getWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")//所有请求都会被拦截，包括静态资源
                        .excludePathPatterns("/", "/signIn","/actuator/**","/data/**","/js/**","/css/**","/mages/**","/images/**","/fonts/**","/error/**");
                registry.addInterceptor(redisUrlCountInterceptor).addPathPatterns("/**")
                        .excludePathPatterns("/","/actuator/**","/data/**","/js/**","/css/**","/mages/**","/images/**","/fonts/**","/error/**");
            }
        };
    }
}
