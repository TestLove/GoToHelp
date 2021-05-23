package cn.testlove.go_to_help.service.impl;

import cn.testlove.go_to_help.entity.Response;
import cn.testlove.go_to_help.entity.User;
import cn.testlove.go_to_help.mapper.UserMapper;
import cn.testlove.go_to_help.service.LoginService;
import cn.testlove.go_to_help.utils.ResponseUtils;
import cn.testlove.go_to_help.utils.WeChatUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 13:23
 * @Description: null
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    /**
     * 如果用户不存在,自动注册再返回token
     * 存在,直接返回token
     * @param appId
     * @param secret
     * @param jsCode
     * @return
     */
    @Override
    public Response login(String appId, String secret, String jsCode) {
        JSONObject info = WeChatUtils.getWeChatAccessToken(appId, secret, jsCode);
        String errCode = info.getString("errcode");
        String errMsg = info.getString("errmsg");
        if (!errCode.equals("0")) {
            return ResponseUtils.failure(errMsg);
        }
        String openId = info.getString("openid");
        String sessionKey = info.getString("session_key");
        User user = userMapper.findUserByOpenID(openId);
        if (user == null) {
            user = new User();
            user.setOpenId(openId);
            user.setAdmin(0);
            user.setSessionKey(sessionKey);
            userMapper.addUser(user);
        }
        String token = WeChatUtils.createToken(user);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("token",token);
        user.setToken(token);
        userMapper.updateUserByOpenId(user);
        return ResponseUtils.success(map);

    }

    @Override
    public Response logout(Integer userId) {
        return null;
    }
}
