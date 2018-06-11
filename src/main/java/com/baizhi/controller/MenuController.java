package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping(value = "/add")
    @ResponseBody
    public void addMenu(Menu menu){
        menuService.insert(menu);
    }
    @RequestMapping(value = "/query",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Menu> queryAll(){
        List<Menu> menus = menuService.queryAll();

        return menus;
    }
}
