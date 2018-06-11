package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/5.
 */
public interface UserService {
    List<User> queryAll();
    void insertAll(List<User> list);
    Map<String,Object> queryByPhone(String phone, String password);
    Map<String,Object> regist(String phone, String password);
    Map<String,Object> update(User user);
    List<User> queryOthersById(Integer id);

}
