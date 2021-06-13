package cn.testlove.go_to_help.entity;

import lombok.Data;

import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/29 10:59
 * @Description: null
 */
@Data
public class PostVO {
    List<String> fileUrl;
    Integer postId;
    Integer userId;
    String postTitle;
    String postContents;
    /**
     * 是否被删除,删除不可见
     * 1. 是
     * 0. 否
     */
    int delete;
    /**
     * 是否过期,过期可见
     * 1. 是
     * 0. 否
     */
    int expired;
    String type;
    String contact;
}
