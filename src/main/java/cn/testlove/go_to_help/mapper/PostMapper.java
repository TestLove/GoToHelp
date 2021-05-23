package cn.testlove.go_to_help.mapper;

import cn.testlove.go_to_help.entity.Post;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 12:34
 * @Description: null
 */
@Mapper
public interface PostMapper {
    /**
     * 用于新增帖子
     * @return
     */
    int insertPost(Post post);

    /**
     * 根据post寻找postid
     * 我也觉得很奇怪,但是如果不这样,数据冗余可能会很大
     * @param post
     * @return
     */
    int selectPostIdByPostId(Post post);
}
