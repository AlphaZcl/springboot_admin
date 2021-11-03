package top.zhuchl.admin.springboot_admin.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author AlphaZcl
 * @Date 2021/11/3
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer sysId;

    private Integer addressId;

    private String userAcco;

    private String userName;

    private String phoneNo;

    private String email;
}
