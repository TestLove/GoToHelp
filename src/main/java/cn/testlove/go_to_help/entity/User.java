package cn.testlove.go_to_help.entity;

import lombok.Data;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 11:53
 * @Description: null
 */
@Data
public class User {
    Integer userId;
    String userName;
    String avatar;
    Integer admin;
    String openId;
    String sessionKey;
    String token;


}
