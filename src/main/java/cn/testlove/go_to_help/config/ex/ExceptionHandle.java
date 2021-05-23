package cn.testlove.go_to_help.config.ex;

import cn.testlove.go_to_help.entity.Response;
import cn.testlove.go_to_help.utils.ResponseUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 16:40
 * @Description: 自定义异常处理
 */
@Component
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(BadTokenException.class)
    public Response badToken(Exception e){
        return ResponseUtils.failure(e.getMessage());
    }
}
