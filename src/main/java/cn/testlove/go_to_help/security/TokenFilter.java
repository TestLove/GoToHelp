package cn.testlove.go_to_help.security;

import cn.testlove.go_to_help.config.ex.BadTokenException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 15:27
 * @Description: null
 */
@WebFilter(urlPatterns = "/*",filterName = "charsetFilter")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        String token = httpServletRequest.getHeader("token");
//        if (token == null || token.length() == 0) {
////           throw new BadTokenException("token错误");
//        }
        HttpServletResponse res = (HttpServletResponse) response;
    res.addHeader("Access-Control-Allow-Credentials", "true");
    res.addHeader("Access-Control-Allow-Origin", "*");
    res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    res.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }


}
