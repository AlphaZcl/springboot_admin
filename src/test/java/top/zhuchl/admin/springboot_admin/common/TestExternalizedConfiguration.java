package top.zhuchl.admin.springboot_admin.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import top.zhuchl.admin.springboot_admin.SpringbootAdminApplicationTests;

/**
 * @Author AlphaZcl
 * @Date 2021/11/16
 **/
@DisplayName("外部配置")
@Slf4j
public class TestExternalizedConfiguration extends SpringbootAdminApplicationTests {

    @Value("${MAVEN_HOME}")
    private String mavenHome;

    @Value("${os.name}")
    private String osName;

    @Test
    @DisplayName("获取环境变量值")
    public void testEnvParam(){
        log.info("mavenHome：{}",mavenHome);
        log.info("osName：{}",osName);
    }
}
