package top.zhuchl.admin.springboot_admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author AlphaZcl
 * @Date 2021/10/30
 **/
@Deprecated
//@WebServlet(urlPatterns = "/my_url")
@Slf4j
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("MySerlvet,request:{}",req.getRequestURI());
        resp.getWriter().write("66666");
    }
}
