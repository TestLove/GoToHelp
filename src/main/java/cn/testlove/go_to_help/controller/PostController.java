package cn.testlove.go_to_help.controller;

import cn.testlove.go_to_help.entity.Post;
import cn.testlove.go_to_help.entity.Response;
import cn.testlove.go_to_help.service.PostService;
import cn.testlove.go_to_help.utils.ResponseUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 12:01
 * @Description: null
 */
@RestController
@RequestMapping("/private")
public class PostController {
    @Autowired
    PostService postService;
    @ApiOperation("upload the post")
    @PostMapping("/addPost")
    public Response insertPost(@ModelAttribute Post post, MultipartFile[] files){
        postService.insertPost(post,files);
        return ResponseUtils.success();
    }
    @ApiOperation("select all post from database")
    @GetMapping("/selectAllPost")
    public Response selectAllPost(){
        HashMap<Object, Object> data = new HashMap<>();
        data.put("data",postService.selectAllPost());
        return ResponseUtils.success(data);
    }
    @ApiOperation("update one post (only support text)")
    @GetMapping("/updatePost")
    public Response updatePost(@RequestBody Post post){
        return ResponseUtils.success();
    }
}
