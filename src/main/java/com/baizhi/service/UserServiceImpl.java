package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.SaltUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Created by Administrator on 2018/6/5.
 */
@Service
@Transactional
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDAO userDAO;

    public void insertAll(List<User> list) {
        userDAO.insertAll(list);
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<User> queryAll() {
        List<User> users = userDAO.queryAll();
        for (User user:users) {
             if (user.getSex().equals("f")){
                 user.setSex("女");
             }else{
                 user.setSex("男");
             }

        }
        return users;
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Map<String,Object> queryByPhone(String phone, String password) {
        Map<String, Object> map = new HashMap<String, Object>();

        if(phone!=null&&password!=null){
            User user = userDAO.queryByPhone(phone);
            String salt=userDAO.querySalt(phone);
            String inputPwd=DigestUtils.md5Hex(password+salt);
            if(inputPwd.equals(user.getPassword())){
                //登录成功
                map.put("user",user);
            }else {
                map.put("error",-200);
                map.put("errmsg","密码错误");
            }
        }else{
            map.put("error",-200);
            map.put("errmsg","账号或密码为空");
        }
        return map;
    }

    public Map<String, Object> regist(String phone, String password) {
        Map<String,Object> map=new HashMap<String, Object>();
        if(phone!=null&&password!=null){
            User user = userDAO.queryByPhone(phone);
            if(user==null){ //未注册
               //密码加密  构造user  完成入库
                String salt= SaltUtil.getSalt();
                String pwd = DigestUtils.md5Hex(password+salt);
                User user1 = new User(phone,pwd,salt,new Date());
                userDAO.insert(user1);
                user=userDAO.queryByPhone(phone);
                map.put("password",user.getPassword());
                map.put("uid",user.getId());
                map.put("phone",user.getPhoneNum());
            }else {
                map.put("error",-200);
                map.put("errmsg","该手机号已存在");
            }
        }else{
            map.put("error",-200);
            map.put("errmsg","账号或密码为空");
        }
        return map;
    }

    public Map<String, Object> update(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(user.getId()!=null){
            userDAO.update(user);
            User user1 = userDAO.queryById(user.getId());
            map.put("user",user1);
        }else{
            map.put("error",-200);
            map.put("errmsg","用户id为空!");
        }
        return map;
    }
    //查询指定id之外的用户
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<User> queryOthersById(Integer id) {
        List<User> list = userDAO.queryNotId(id);
        return list;
    }
}
