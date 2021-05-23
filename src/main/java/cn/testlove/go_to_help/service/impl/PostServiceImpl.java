package cn.testlove.go_to_help.service.impl;

import cn.testlove.go_to_help.entity.Post;
import cn.testlove.go_to_help.entity.PostFile;
import cn.testlove.go_to_help.mapper.PostFileMapper;
import cn.testlove.go_to_help.mapper.PostMapper;
import cn.testlove.go_to_help.mapper.UserMapper;
import cn.testlove.go_to_help.service.PostService;
import cn.testlove.go_to_help.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 17:54
 * @Description: null
 */
@Service
@Slf4j
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    PostFileMapper postFileMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPost(Post post, MultipartFile[] files) {
        log.info(post.toString());
        postMapper.insertPost(post);
        Integer postId = postMapper.selectPostIdByPostId(post);
        for (MultipartFile file : files) {
            PostFile postFile = new PostFile();
            postFile.setPostId(postId);
            FileUtils.uploadFile(file,postFile);
            log.info(postFile.toString());
            postFileMapper.insertFile(postFile);
        }

        return 0;
    }
}
