package top.zhuchl.admin.springboot_admin.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import top.zhuchl.admin.springboot_admin.SpringbootAdminApplicationTests;
import top.zhuchl.admin.springboot_admin.pojo.User;


/**
 * @Author AlphaZcl
 * @Date 2021/11/16
 **/
@DisplayName("参数配置测试")
@Slf4j
public class ConfigurationTest extends SpringbootAdminApplicationTests {

    @Autowired
    private User user;

    @Test
    @DisplayName("参数绑定配置")
    public void testConfig(){
        Assert.notNull(user,"不为空");
        log.info("user:{}",user);
    }
}
