package top.zhuchl.admin.springboot_admin.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * servlet组件
 *
 * @Author AlphaZcl
 * @Date 2021/11/2
 **/
@WebFilter(urlPatterns = {"/css/*","/images/*"})
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter doFilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("MyFilter destroy");
    }
}
