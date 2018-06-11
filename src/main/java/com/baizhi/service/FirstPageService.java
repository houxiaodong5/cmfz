package com.baizhi.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2018/6/6.
 */
public interface FirstPageService {
    Map<String,Object> query(String uid, String type, String sub_type);
}
