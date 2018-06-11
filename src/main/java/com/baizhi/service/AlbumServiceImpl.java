package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/3.
 */
@Service
@Transactional
public class AlbumServiceImpl implements  AlbumService {
    @Autowired
    private AlbumDAO albumDAO;
    @Autowired
    private ChapterDAO chapterDAO;
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<Album> queryAll() {
        List<Album> list=albumDAO.queryAll();
        return list;
    }

    public void insert(Album album) {
        album.setPublishDate(new Date());
        albumDAO.insert(album);
    }
    //根据专辑id查询专辑
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Map<String,Object> queryById(String id,String uid) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(id!=null){
            Album album = albumDAO.queryById(Integer.valueOf(id));//查询专辑
            map.put("introduction",album);
            List<Chapter> chapters = chapterDAO.queryById(Integer.valueOf(id));//查询章节列表
            map.put("list",chapters);
        }


        return map;
    }
}
