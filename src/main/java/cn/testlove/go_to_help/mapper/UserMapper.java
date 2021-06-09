package cn.testlove.go_to_help.mapper;

import cn.testlove.go_to_help.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 11:52
 * @Description: null
 */
@Mapper
public interface UserMapper {
    /**
     *
     * @param openID
     * @return
     */
    User findUserByOpenID(String openID);

    /**
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     *
     * @param user
     * @return
     */
    int updateUserByOpenId(User user);
}
