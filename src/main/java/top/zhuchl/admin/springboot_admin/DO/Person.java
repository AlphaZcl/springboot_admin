package top.zhuchl.admin.springboot_admin.DO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigInteger;

/**
 * @Author AlphaZcl
 * @Date 2021/11/9
 **/
@Data
@TableName("PERSONINF")
public class Person {

    @TableId
    private BigInteger id;

    private String name;

    private Integer age;

    private String email;
}
