package com.baizhi.service;

import com.aliyuncs.exceptions.ClientException;

import java.util.Map;

/**
 * Created by Administrator on 2018/6/6.
 */
public interface IdentifyService {
    void getCheckCode(String phone) throws ClientException;
    Map<String,String> checkCaptcha(String phone,String code);
}
