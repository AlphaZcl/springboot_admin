package top.zhuchl.admin.springboot_admin.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


/**
 * @Author AlphaZcl
 * @Date 2021/11/13
 **/
@DisplayName("断言测试")
public class AssertionsTest {

    @DisplayName("简单断言测试")
    @Test
    public void testAssertions(){
        assertEquals(5,5,"计算失败");
        assertNotEquals(3,4,"结果相等");
        assertSame("13","13","不相等");
    }

    @DisplayName("array assert")
    @Test
    public void testAssertArray(){
        assertArrayEquals(new int[]{1,2},new int[]{1,2},"数组不相等");
    }

    @Test
    @DisplayName("组合断言")
    public void testAssertAll(){
        assertAll("test",
                ()-> assertTrue(true || false,"不是true"),
                ()-> assertEquals(1,1,"不相等"));
    }

    @DisplayName("异常断言")
    @Test
    public void testAssertThrows(){
        assertThrows(NullPointerException.class,()->{String s = null; s.length();},"居然成功了");
    }

    @DisplayName("超时断言")
    @Test
    public void testAssertTimeOut(){
        assertTimeout(Duration.ofMillis(4000),()->{try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        },"超过时限");
    }

    @DisplayName("失败断言")
    @Test
    public void testAssertFail(){
        if(false){
            fail("测试失败");
        }
    }
}
