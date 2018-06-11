package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public interface ChapterDAO {
    void insert(Chapter chapter);
    List<Chapter> queryById(Integer id);
}
