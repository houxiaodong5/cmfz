package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Album;
import com.baizhi.entity.RotationChart;
import com.baizhi.service.FirstPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/6.
 */
@Controller
@RequestMapping("/first_page")
public class FirstPageController {
    @Autowired
    private FirstPageService firstPageService;
    @ResponseBody
    @RequestMapping("/get")
    public JSONObject getFirstPage(String uid, String type, String sub_type){
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = firstPageService.query(uid, type, sub_type);
        //获取轮播图数据
        List<RotationChart> list=(List<RotationChart>)map.get("header");
        //获取专辑数据
        List<Album> albums=(List<Album>)map.get("album");
        jsonObject.put("header",list);
        jsonObject.put("album",albums);
        return jsonObject;
    }
}
