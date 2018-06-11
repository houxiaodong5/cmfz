package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/3.
 */
public interface AlbumService {
    void insert(Album album);
    List<Album> queryAll();
    Map<String,Object> queryById(String id,String uid);
}
