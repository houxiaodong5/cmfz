package com.baizhi.service;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
@Service
public class MenuServiceImpl implements  MenuService {
    @Autowired
    private MenuDAO menuDAO;
    public void insert(Menu menu) {
        menuDAO.insert(menu);
    }

    public List<Menu> queryAll() {
        List<Menu> list=menuDAO.queryAll();
        for (Menu m:list
             ) {
            System.out.println(m);
            System.out.println("SERVICE");
        }
        return list;
    }
}
