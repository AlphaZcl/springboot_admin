package top.zhuchl.admin.springboot_admin.mapper;

import top.zhuchl.admin.springboot_admin.DO.UserInfo;

import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/11/8
 **/
public interface UserInfoMapper {

    List<UserInfo> findAll();
}
