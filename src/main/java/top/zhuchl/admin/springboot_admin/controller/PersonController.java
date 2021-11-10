package top.zhuchl.admin.springboot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.zhuchl.admin.springboot_admin.DO.Person;
import top.zhuchl.admin.springboot_admin.service.PersonService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/11/9
 **/
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("getPerson")
    public List<Person> personList(){
        List<Person> pls =  personService.list();
        return pls;
    }
}
