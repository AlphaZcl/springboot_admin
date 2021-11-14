package top.zhuchl.admin.springboot_admin.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * @Author AlphaZcl
 * @Date 2021/11/13
 **/
@DisplayName("Junit5测试")
@Slf4j
public class Junit5Test {

    @Test
    @DisplayName("测试DisplayName注解")
    public void testDisplayName(){
        log.info("testDisplayName");
    }

    @DisplayName("重复测试")
    @RepeatedTest(3)
    public void testRepeatedTest(){
        log.info("repeated=========");
    }

    @ParameterizedTest
    @DisplayName("参数测试")
    @Disabled
    public void testParameterizedTest(){

    }

    @BeforeEach
    public void testBeforeEach(){
        log.info("before");
    }

    @AfterEach
    public void testAfterEach(){
        log.info("after");
    }

    @BeforeAll
    static public void testBeforeAll(){
        log.info("all test begin");
    }

    @AfterAll
    static public void testAfterAll(){
        log.info("all test end");
    }
}
