package top.zhuchl.admin.springboot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.zhuchl.admin.springboot_admin.exception.UserTooManyException;
import top.zhuchl.admin.springboot_admin.pojo.User;

import java.util.Arrays;
import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/10/27
 **/
@Controller
@RequestMapping
@Slf4j
public class TableController {

    @GetMapping("basicTable")
    public String basicTable(@RequestParam("b")int b){
        log.info("basic_table");
        int a =  10/0;
        return "table/basic_table";
    }

    @GetMapping("dynamicTable")
    public String dynamicTable(Model model){
        log.info("dynamic_table");
        /*表格内容遍历*/
        List<User> users = Arrays.asList(new User("zhangsan", "012345"),
                new User("lisi", "012345"),
                new User("wangwu", "012345"),
                new User("maliu", "012345"),
                new User("zhaoqi", "012345"));
        model.addAttribute("users",users);
        if(users.size()>4){
            throw new UserTooManyException();
        }
        return "table/dynamic_table";
    }

    @GetMapping("responsiveTable")
    public String responsiveTable(){
        log.info("responsive_table");
        return "table/responsive_table";
    }

    @GetMapping("editableTable")
    public String editableTable(){
        log.info("editable_table");
        return "table/editable_table";
    }

}
