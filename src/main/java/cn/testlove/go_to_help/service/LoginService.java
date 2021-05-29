package cn.testlove.go_to_help.service;

import cn.testlove.go_to_help.entity.Response;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 13:23
 * @Description: null
 */
public interface LoginService {
    public Response login(String jsCode);
    public Response logout(Integer userId);
}
