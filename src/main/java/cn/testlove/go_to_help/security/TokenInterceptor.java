package cn.testlove.go_to_help.security;

import cn.testlove.go_to_help.config.ex.BadTokenException;
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
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("token");
        if (token == null || token.length() == 0) {
           throw new BadTokenException("token错误");
        }
        return true;
    }
}
