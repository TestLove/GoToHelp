package cn.testlove.go_to_help.entity;

import lombok.Data;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 12:33
 * @Description: null
 */
@Data
public class PostFile {
    Integer fileId;
    Integer postId;
    String fileUrl;
    String filePath;
    /**
     * 文件是否有效
     * 1. 有效
     * 0. 无效
     */
    int active;

}
