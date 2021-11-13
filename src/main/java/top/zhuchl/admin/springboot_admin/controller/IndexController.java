package top.zhuchl.admin.springboot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import top.zhuchl.admin.springboot_admin.DO.UserInfo;
import top.zhuchl.admin.springboot_admin.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * @Author AlphaZcl
 * @Date 2021/10/26
 **/
@Controller
@RequestMapping
@Slf4j
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value={"loginPage","/"})
    public String loginPage(){
        log.info("登录页面");
        return "login";
    }

    @RequestMapping ("signIn")
    public String login(User user,HttpSession session){
        log.info("登录信息认证:{}",user);
        String url = "login";
        if(user != null && StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
            url = "redirect:mainPage";
            session.setAttribute("user",user);
        }
        return url;
    }

    @GetMapping("mainPage")
    public String mainPage(@SessionAttribute(required = false) User user){
        log.info("进入主页User:{}",user);
//        String url = "login";
//        if(user != null && StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
//            url = "main";
//        }
        return "main";
    }

    @GetMapping("querySql")
    @ResponseBody
    public UserInfo tesSql(){
        String sql = "SELECT * FROM user_info WHERE sys_id=?";
        Object[] args = {1};
        UserInfo userInfo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserInfo.class), args);
        log.info("query userinfo : {}",userInfo);
        return userInfo;
    }

}
