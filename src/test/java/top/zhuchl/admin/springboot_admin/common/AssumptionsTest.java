package top.zhuchl.admin.springboot_admin.common;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @Author AlphaZcl
 * @Date 2021/11/13
 **/
@DisplayName("前置条件")
public class AssumptionsTest {

    private final String env = "DEV";

    private boolean isGoOn(){
        return true;
    }

    @DisplayName("前置条件")
    @Test
    public void testAssumption(){
        Assumptions.assumeFalse(Objects.equals(this.env,"PRO"));
        System.out.println("ssss");
        Assumptions.assumeTrue(()->isGoOn());
        System.out.println("sssssss");
    }

    @Test
    @DisplayName("AssumptionThat")
    public void testAssumptionThat(){
        Assumptions.assumingThat(Objects.equals(this.env,"DEV"),()->service());
    }

    public void service(){
        System.out.println("do service");
    }

}
