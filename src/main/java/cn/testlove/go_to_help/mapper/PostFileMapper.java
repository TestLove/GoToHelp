package cn.testlove.go_to_help.mapper;

import cn.testlove.go_to_help.entity.Post;
import cn.testlove.go_to_help.entity.PostFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 20:58
 * @Description: null
 */
@Mapper
public interface PostFileMapper {
    /**
     * 添加文件
     * @param file
     * @return
     */
    int insertFile(PostFile file);

    /**
     * 根据postId查找文件
     * @param postId
     * @return
     */
    List<String> selectFile(int postId);


}
