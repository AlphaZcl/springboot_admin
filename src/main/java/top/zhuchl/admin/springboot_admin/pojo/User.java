package top.zhuchl.admin.springboot_admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author AlphaZcl
 * @Date 2021/10/26
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("pojo.user")
public class User {

    private String userName;

    private String password;
}
