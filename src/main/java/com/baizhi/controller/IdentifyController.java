package com.baizhi.controller;

import com.aliyuncs.exceptions.ClientException;
import com.baizhi.service.IdentifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018/6/6.
 */
@Controller
@RequestMapping("/identify")
public class IdentifyController {
   @Autowired
    private IdentifyService identifyService;
    //获取短信验证码接口
    @ResponseBody
    @RequestMapping("/obtain")
    public void getCheckCode(String phone){
        try {
            identifyService.getCheckCode(phone);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    //短信验证码校验接口
    @RequestMapping(value = "/check")
    @ResponseBody
    public Map<String,String> checkCaptcha(String phone,String code){
        Map<String, String> map = identifyService.checkCaptcha(phone, code);
        return map;
    }
}
