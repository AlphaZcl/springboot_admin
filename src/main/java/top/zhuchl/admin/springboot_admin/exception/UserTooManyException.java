package top.zhuchl.admin.springboot_admin.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author AlphaZcl
 * @Date 2021/10/30
 **/
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户太多")
@NoArgsConstructor
public class UserTooManyException extends RuntimeException{

    public UserTooManyException(String message){
        super(message);
    }
}
