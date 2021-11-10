package top.zhuchl.admin.springboot_admin.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.zhuchl.admin.springboot_admin.DO.Person;
import top.zhuchl.admin.springboot_admin.SpringbootAdminApplicationTests;
import top.zhuchl.admin.springboot_admin.mapper.PersonMapper;

import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/11/9
 **/
@Slf4j
public class MyBatisPlusTest extends SpringbootAdminApplicationTests {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testQuery(){
        List<Person> personList = personMapper.selectByMap(null);
        log.info("res : {}",personList);
        personList.forEach(System.out::println);
    }
}
