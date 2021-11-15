package top.zhuchl.admin.springboot_admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.zhuchl.admin.springboot_admin.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author AlphaZcl
 * @Date 2021/11/12
 **/
@Component
@Slf4j
@Order(2)
public class RedisUrlCountInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("========RedisUrlCountInterceptor preHandle==========");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("=========RedisUrlCountInterceptor postHandle===========");
        User user = (User) request.getSession().getAttribute("user");
        log.info("登录验证 user：{}",user);
        if( user != null && StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
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
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("=========RedisUrlCountInterceptor afterCompletion===========");
    }
}
