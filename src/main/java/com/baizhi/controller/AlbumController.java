package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Album;
import com.baizhi.entity.FileParam;
import com.baizhi.service.AlbumService;
import com.baizhi.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/3.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/add")
    @ResponseBody
    public  void addAlbum(Album album, MultipartFile img, HttpServletRequest request){
        FileParam fileParam = UploadUtil.uploadFile(img, request, UploadUtil.IMG);
        album.setCoverImg(fileParam.getUrl());
        albumService.insert(album);
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<Album> queryAll(){
        List<Album> list=albumService.queryAll();
        return list;
    }

    //闻的详情页接口        id: 专辑id   uid: 用户id
    @RequestMapping("/wen")
    @ResponseBody
    public JSONObject getAlbum(String id,String uid){
        JSONObject jsonObject=new JSONObject();
        Map<String, Object> map = albumService.queryById(id, uid);
        jsonObject.put("introduction",map.get("introduction"));
        jsonObject.put("list",map.get("list"));
        return  jsonObject;
    }
}
