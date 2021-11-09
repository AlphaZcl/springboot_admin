package top.zhuchl.admin.springboot_admin.service;

import org.springframework.stereotype.Service;
import top.zhuchl.admin.springboot_admin.DO.UserInfo;

import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/11/8
 **/
public interface UserService {

    List<UserInfo> findAll();
}
