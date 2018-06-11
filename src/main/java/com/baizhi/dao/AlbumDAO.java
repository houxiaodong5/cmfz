package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2018/6/3.
 */
public interface AlbumDAO {
    void insert(Album album);
    List<Album> queryAll();
    Album queryById(Integer id);
}
