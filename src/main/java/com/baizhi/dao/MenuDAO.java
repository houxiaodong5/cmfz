package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public interface MenuDAO {
    void insert(Menu menu);
    List<Menu> queryAll();
}
