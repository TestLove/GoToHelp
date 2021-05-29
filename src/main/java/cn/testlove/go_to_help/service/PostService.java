package cn.testlove.go_to_help.service;

import cn.testlove.go_to_help.entity.Post;
import cn.testlove.go_to_help.entity.PostVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 17:54
 * @Description: null
 */
public interface PostService {
    int insertPost(Post post, MultipartFile[] files);

    /**
     *
     * @return
     */
    List<PostVO> selectAllPost();
}
