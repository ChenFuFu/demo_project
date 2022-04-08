package com.example.dynamic_data_source.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2022/4/8
 * @Time 09:59
 * @Description controller返回结果集工具类
 * A0001---用户范围出现异常 B0001---服务端出现异常 C0001---第三方服务出现异常
 */

public class ResultHelper {

    private static final Map<String, Object> resultMap = new HashMap<>();

    public static Map<String, Object> success() {
        resultMap.put("code", "00000");
        resultMap.put("msg", "操作成功");
        return resultMap;
    }

    public static Map<String, Object> success(Object data) {
        resultMap.put("code", "00000");
        resultMap.put("msg", "操作成功");
        resultMap.put("data", data);
        return resultMap;
    }

    public static Map<String, Object> systemException() {
        resultMap.put("code", "B0001");
        resultMap.put("msg", "系统异常");
        return resultMap;
    }

    public static Map<String, Object> paramsException() {
        resultMap.put("code", "A0001");
        resultMap.put("msg", "参数异常");
        return resultMap;
    }
}
