package cn.testlove.go_to_help.controller;

import cn.testlove.go_to_help.entity.Response;
import cn.testlove.go_to_help.utils.ResponseUtils;
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
    @PostMapping("/login")
    public Response login(){

        return ResponseUtils.success();
    }
    @PostMapping("/logout")
    public Response logout(){

        return ResponseUtils.success();
    }


}
