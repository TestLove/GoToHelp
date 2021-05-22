package cn.testlove.go_to_help.controller;

import cn.testlove.go_to_help.entity.Post;
import cn.testlove.go_to_help.entity.Response;
import cn.testlove.go_to_help.utils.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 12:01
 * @Description: null
 */
@RestController
@RequestMapping("/private")
public class PostController {
    @PostMapping("/addPost")
    public Response insertPost(Post post){
        return ResponseUtils.success();
    }
}
