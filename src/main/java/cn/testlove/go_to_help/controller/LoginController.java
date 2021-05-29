package cn.testlove.go_to_help.controller;

import cn.testlove.go_to_help.config.ex.BadTokenException;
import cn.testlove.go_to_help.entity.Response;
import cn.testlove.go_to_help.service.LoginService;
import cn.testlove.go_to_help.utils.ResponseUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 12:35
 * @Description: null
 */
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @ApiOperation("acquire accessToken(as the credential to visit the resources)")
    @PostMapping("/public/login")
    public Response login(String jsCode){
        return loginService.login(jsCode);
    }
    @ApiOperation("logout")
    @PostMapping("/private/logout")
    public Response logout(Integer userId){
        loginService.logout(userId);
        return ResponseUtils.success();
    }


}
