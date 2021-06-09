package cn.testlove.go_to_help.service;

import cn.testlove.go_to_help.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 11:52
 * @Description: null
 */
public interface UserService {
    int updateUserByOpenId(User user);
}
