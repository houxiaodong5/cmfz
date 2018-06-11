package com.baizhi.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.RotationChartDAO;
import com.baizhi.entity.Album;
import com.baizhi.entity.RotationChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/6.
 */
@Service
@Transactional
public class FirstPageServiceImpl implements FirstPageService {
    @Autowired
    private RotationChartDAO rotationChartDAO;//轮播图dao
    @Autowired
    private AlbumDAO albumDAO;//专辑dao
    /*uid:用户id  type{all:首页,wen:闻,si:思}  sub_type{ssyj:上师言教,xmfy:显密法要}<选填>*/
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Map<String, Object> query(String uid, String type, String sub_type) {
        Map<String, Object> map=new HashMap<String, Object>();
        //查询轮播图及专辑
        if (type.equals("all")) {
            List<RotationChart> rotationCharts = rotationChartDAO.queryAll();
            map.put("header",rotationCharts);
            //查询专辑
            List<Album> albums = albumDAO.queryAll();
            map.put("album",albums);
        }
        if(uid!=null){
        //查询用户上师的文章

        }
            return map;
    }
}
