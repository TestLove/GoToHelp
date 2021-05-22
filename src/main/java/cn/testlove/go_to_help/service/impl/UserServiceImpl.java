package cn.testlove.go_to_help.service.impl;

import cn.testlove.go_to_help.entity.User;
import cn.testlove.go_to_help.mapper.UserMapper;
import cn.testlove.go_to_help.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 11:53
 * @Description: null
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public int updateUserByOpenId(User user) {
        return userMapper.updateUserByOpenId(user);
    }
}
