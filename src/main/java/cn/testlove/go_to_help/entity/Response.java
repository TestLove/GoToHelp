package cn.testlove.go_to_help.entity;

import lombok.Data;

import java.util.HashMap;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 12:36
 * @Description: null
 */
@Data
public class Response {
    int errorCode;
    String errorMessage;
    Object data;

}
