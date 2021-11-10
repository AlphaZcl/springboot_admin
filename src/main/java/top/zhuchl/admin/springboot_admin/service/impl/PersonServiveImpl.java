package top.zhuchl.admin.springboot_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zhuchl.admin.springboot_admin.DO.Person;
import top.zhuchl.admin.springboot_admin.mapper.PersonMapper;
import top.zhuchl.admin.springboot_admin.service.PersonService;

/**
 * @Author AlphaZcl
 * @Date 2021/11/9
 **/
@Service
public class PersonServiveImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {
}
