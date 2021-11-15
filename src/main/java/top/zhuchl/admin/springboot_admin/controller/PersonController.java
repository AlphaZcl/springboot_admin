package top.zhuchl.admin.springboot_admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.zhuchl.admin.springboot_admin.DO.Person;
import top.zhuchl.admin.springboot_admin.VO.PersonVO;
import top.zhuchl.admin.springboot_admin.service.PersonService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/11/9
 **/
@RestController
@RequestMapping("data")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("getPerson")
    public List<Person> personList(){
        List<Person> pls =  personService.list();
        log.info("pls:{}",pls);
        return pls;
    }

    @GetMapping("getPersonPage")
    public PersonVO queryList(@RequestParam Integer current, @RequestParam Integer size,@RequestParam(required = false,defaultValue = "0") Integer age){
        PersonVO personVO = new PersonVO();
        IPage<Person> personIPage = personService.selectUserPage(current, size, age);
        personVO.setPersonList(personIPage.getRecords());
        personVO.setTotal(personIPage.getTotal());
        personVO.setSize(personIPage.getSize());
        personVO.setCurrentPage(personIPage.getCurrent());
        return personVO;
    }
}
