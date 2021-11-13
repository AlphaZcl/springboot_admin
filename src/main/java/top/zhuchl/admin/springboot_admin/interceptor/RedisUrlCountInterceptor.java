package top.zhuchl.admin.springboot_admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @Author AlphaZcl
 * @Date 2021/11/12
 **/
@Component
@Slf4j
public class RedisUrlCountInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("requestURI:{}",requestURI);
        String contextPath = request.getContextPath();
        String key = contextPath  + "/signIn";
        log.info("key :{}",key);
        if(requestURI.equals(key)){
            ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
            opsForValue.increment(requestURI);
            log.info("登录请求次数：{}",opsForValue.get(key));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
