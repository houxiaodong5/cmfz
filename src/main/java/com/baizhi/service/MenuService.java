package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public interface MenuService {
    void insert(Menu menu);
    List<Menu> queryAll();
}
