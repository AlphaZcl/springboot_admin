package top.zhuchl.admin.springboot_admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhuchl.admin.springboot_admin.DO.Person;
import top.zhuchl.admin.springboot_admin.mapper.PersonMapper;
import top.zhuchl.admin.springboot_admin.service.PersonService;

/**
 * @Author AlphaZcl
 * @Date 2021/11/9
 **/
@Service
@Slf4j
public class PersonServiveImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    Counter counter;

    public PersonServiveImpl(MeterRegistry registry) {
        counter = registry.counter("PersonServiveImpl.selectUserPage.counter");
    }

    @Override
    public IPage<Person> selectUserPage(Integer current, Integer size, Integer age) {
        counter.increment();
        IPage<Person> page = new Page<>(current, size);
        IPage<Person> personIPage = personMapper.selectPageVo(page, age);
        log.info("req's page is rsp's page ? {}", (page == personIPage));
        log.info("query result : {}", personIPage.getRecords());
        return personIPage;
    }
}
