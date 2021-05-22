package cn.testlove.go_to_help.controller;

import cn.testlove.go_to_help.entity.Response;
import cn.testlove.go_to_help.entity.User;
import cn.testlove.go_to_help.utils.ResponseUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 15:15
 * @Description: null
 */
@RestController
@RequestMapping("/private")
public class UserController {
    @ApiOperation("更新用户信息")
    @PostMapping("/updateUserInfo")
    public Response updateUserInfo(@RequestBody User user){
        return ResponseUtils.success();
    }
}
