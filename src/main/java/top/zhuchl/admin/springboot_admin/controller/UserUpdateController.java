package top.zhuchl.admin.springboot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhuchl.admin.springboot_admin.DO.UserInfo;
import top.zhuchl.admin.springboot_admin.service.UserService;

import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/11/8
 **/
@RestController
@Slf4j
public class UserUpdateController {

    @Autowired
    private UserService userService;

    @GetMapping("getAll")
    public List<UserInfo> getAllUser() {
        List<UserInfo> all = userService.findAll();
        log.info("UserInfo List : {}", all);
        return all;
    }
}
