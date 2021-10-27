package top.zhuchl.admin.springboot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String dynamicTable(){
        log.info("dynamic_table");
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
