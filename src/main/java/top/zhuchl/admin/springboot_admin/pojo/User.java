package top.zhuchl.admin.springboot_admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author AlphaZcl
 * @Date 2021/10/26
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;

    private String password;
}
