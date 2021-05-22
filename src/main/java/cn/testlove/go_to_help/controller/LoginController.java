package cn.testlove.go_to_help.controller;

import cn.testlove.go_to_help.config.ex.BadTokenException;
import cn.testlove.go_to_help.entity.Response;
import cn.testlove.go_to_help.service.LoginService;
import cn.testlove.go_to_help.utils.ResponseUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation("登陆接口")
    @PostMapping("/public/login")
    public Response login(String appId, String secret, String jsCode){
       if(appId.length()==1){
           throw new BadTokenException("token错误");
       }
        return loginService.login(appId, secret, jsCode);
    }
    @ApiOperation("注销接口")
    @PostMapping("/private/logout")
    public Response logout(){

        return ResponseUtils.success();
    }


}
