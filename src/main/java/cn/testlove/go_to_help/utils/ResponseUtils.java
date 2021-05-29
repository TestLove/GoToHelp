package cn.testlove.go_to_help.utils;

import cn.testlove.go_to_help.entity.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 12:37
 * @Description: null
 */
public class ResponseUtils {
    public static Response success(){
        Response response = new Response();
        response.setErrorCode(0);
        response.setErrorMessage("执行成功");
        return response;

    }
    public static Response success(HashMap data){
        Response response = new Response();
        response.setErrorCode(0);
        response.setErrorMessage("success");
        response.setData(data);
        return response;

    }
    public static Response failure(String message){
        Response response = new Response();
        response.setErrorCode(1);
        response.setErrorMessage(message);
        return response;

    }
    public static Response failure(HashMap data){
        Response response = new Response();
        response.setErrorCode(0);
        response.setErrorMessage("error");
        response.setData(data);
        return response;

    }
}
