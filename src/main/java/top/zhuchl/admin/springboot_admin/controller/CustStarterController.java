package top.zhuchl.admin.springboot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhuchl.hello.service.HelloService;

/**
 * @Author AlphaZcl
 * @Date 2021/11/16
 **/
@RestController
@RequestMapping("data")
@Slf4j
public class CustStarterController {

    @Autowired
    private HelloService helloService;

    @GetMapping("hello")
    public String sayHello(String username){
        log.info("username：{}",username);
        return helloService.sayHello(username);
    }
}
