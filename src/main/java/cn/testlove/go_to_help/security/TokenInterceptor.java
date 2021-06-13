package cn.testlove.go_to_help.security;

import cn.testlove.go_to_help.config.ex.BadTokenException;
import cn.testlove.go_to_help.entity.User;
import cn.testlove.go_to_help.mapper.UserMapper;
import cn.testlove.go_to_help.utils.WeChatUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 17:11
 * @Description: 用于拦截没有token以及token错误的情况
 */
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("token");
        log.info("token is: "+token);

        if (token == null || token.length() == 0) {
            log.error("don't exist token");
           throw new BadTokenException("token error");
        }
        String[] split = token.split(":");
        if(split.length != 2){
            log.error("token format error");
            throw new BadTokenException("token error");
        }
        token = split[1];
        User user = userMapper.findUserByUserId(Integer.valueOf(split[0]));
        if (user == null) {
            log.error("user not exist");
            throw new BadTokenException("token error");
        }
        String oToken = user.getToken();
        log.info(oToken);
        if (oToken == null || oToken.length() == 0) {
            log.error("the user has logout");
            throw new BadTokenException("login again");
        }
        if(!oToken.equals(token)){
            log.error("the token is not match");
            throw new BadTokenException("token error");
        }
        return true;
    }
}
