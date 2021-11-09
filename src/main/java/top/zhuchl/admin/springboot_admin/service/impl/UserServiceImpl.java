package top.zhuchl.admin.springboot_admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhuchl.admin.springboot_admin.DO.UserInfo;
import top.zhuchl.admin.springboot_admin.mapper.UserInfoMapper;
import top.zhuchl.admin.springboot_admin.service.UserService;

import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/11/8
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> all = userInfoMapper.findAll();
        return all;
    }
}
