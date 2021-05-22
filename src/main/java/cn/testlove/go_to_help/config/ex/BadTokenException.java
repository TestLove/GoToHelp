package cn.testlove.go_to_help.config.ex;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 16:39
 * @Description: token认证异常
 */
public class BadTokenException extends RuntimeException{
    public BadTokenException(String message){
        super(message);
    }
}
