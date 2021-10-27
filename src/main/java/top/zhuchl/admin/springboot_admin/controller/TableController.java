package top.zhuchl.admin.springboot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.zhuchl.admin.springboot_admin.pojo.User;

import java.util.Arrays;
import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/10/27
 **/
@Controller
@Slf4j
public class TableController {

    @GetMapping("basicTable")
    public String basicTable(){
        log.info("basic_table");
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
