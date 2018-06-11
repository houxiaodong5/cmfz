package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Filed;
import com.baizhi.entity.User;
import com.baizhi.poi.UserAnnoation;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryAll() {
        List<User> users = userService.queryAll();
        for (User u : users
                ) {
            System.out.println(u);
        }
        return users;
    }

    @ResponseBody
    @RequestMapping("/filed")
    public List<Filed> getFiled() {
        List<Filed> list = new ArrayList<Filed>();
        Class<User> userClass = User.class;
        //获取filed类中所有属性
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            Filed filed = new Filed();
            filed.setId(field.getName());
            //获取属性的注解
            UserAnnoation annotation = field.getAnnotation(UserAnnoation.class);
            filed.setText(annotation.name());
            list.add(filed);
        }
        return list;
    }
    //服务端登录接口

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public Object login(String phone,String password){
        //JSONObject jsonObject=new JSONObject();
        User user=null;
        Map<String, Object> map = userService.queryByPhone(phone, password);
        if(map.get("error")==null){
            user = (User) map.get("user");
            //jsonObject.put(user);
            return user;
        }else{
            return  map;
        }

    }
    //服务器注册接口
    @ResponseBody
    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public Map<String, Object> regist(String phone,String password){
        Map<String, Object> map = userService.regist(phone, password);
        return  map;
    }

    //修改个人信息接口
    @ResponseBody
    @RequestMapping(value="/modify",method = RequestMethod.POST)
    public Object modify(User user){
        Map<String, Object> map = userService.update(user);
        if(map.get("error")==null){
            User us=(User) map.get("user");
            return us;
        }else{
            return map;
        }
    }
    //获取会员列表接口
    @ResponseBody
    @RequestMapping("/member")
    public List<User> getMember(String uid){
        List<User> list = userService.queryOthersById(Integer.valueOf(uid));
        return  list;
    }

}
