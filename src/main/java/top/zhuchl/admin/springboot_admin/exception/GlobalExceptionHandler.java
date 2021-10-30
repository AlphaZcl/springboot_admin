package top.zhuchl.admin.springboot_admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web的异常
 *
 * @Author AlphaZcl
 * @Date 2021/10/30
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,
            NullPointerException.class,
            MissingServletRequestParameterException.class
    })
    public String handleArithException(Exception ex) {
        log.error("异常是:{}", ex);
        return "login";
    }
}
