package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5.
 */
public interface UserDAO {
    List<User> queryAll();
    void insertAll(List<User> list);
    User queryByPhone(String phone);
    String querySalt(String phone);
    void insert(User user);
    void update(User user);
    User queryById(Integer id);
    List<User> queryNotId(Integer id);
}
