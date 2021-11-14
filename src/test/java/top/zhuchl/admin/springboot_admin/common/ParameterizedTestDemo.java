package top.zhuchl.admin.springboot_admin.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import top.zhuchl.admin.springboot_admin.common.enums.ArgEnum;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author AlphaZcl
 * @Date 2021/11/13
 **/
@DisplayName("参数化测试")
public class ParameterizedTestDemo {

    @ParameterizedTest
    @DisplayName("int类型参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    public void testValueSource(int i){
        System.out.println(i);
    }

    @NullSource
    @ParameterizedTest
    @DisplayName("null 参数")
    public void  testNullSource(Object arg){
        assertNull(arg);
    }

    @EnumSource(ArgEnum.class)
    @ParameterizedTest
    @DisplayName("Enum 参数")
    public void testEnumSource(ArgEnum argEnum){
        System.out.println(argEnum.getKey()+":"+argEnum.getValue());
    }

    @ParameterizedTest
    @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
    void testWithCsvSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }
}
