package top.zhuchl.admin.springboot_admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.zhuchl.admin.springboot_admin.DO.Person;

/**
 * @Author AlphaZcl
 * @Date 2021/11/9
 **/
public interface PersonService extends IService<Person> {

    IPage<Person> selectUserPage(Integer current,Integer size,Integer age);
}
