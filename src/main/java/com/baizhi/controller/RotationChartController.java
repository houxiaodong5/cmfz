package com.baizhi.controller;

import com.baizhi.entity.FileParam;
import com.baizhi.entity.RotationChart;
import com.baizhi.service.RotationChartService;
import com.baizhi.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
@Controller
@RequestMapping("/rc")
public class RotationChartController {
    @Autowired
    private RotationChartService rcs;
    @ResponseBody
    @RequestMapping("/add")
    public void addRotationChart(RotationChart rc,MultipartFile addFile, HttpServletRequest request){
        System.out.println(addFile+"-------------");
        FileParam fileParam=UploadUtil.uploadFile(addFile, request, UploadUtil.IMG);
        rc.setImgPath(fileParam.getUrl());

        rc.setDate(new Date());
        rcs.insert(rc);
        System.out.println("++++++++++++++");
    }
    @ResponseBody
    @RequestMapping(value = "/query")
    public List<RotationChart> queryRotationChart(){
        List<RotationChart> list=rcs.queryAll();
        for (RotationChart r:list
             ) {
            System.out.println(r);
        }
        return list;
    }
    @ResponseBody
    @RequestMapping("/delete")
    public  void  deleteRotationChart(String id){
        rcs.delete(Integer.parseInt(id));

    }
    @ResponseBody
    @RequestMapping("/update")
    public  RotationChart update(RotationChart rc){
        System.out.println(rc);
        rcs.update(rc);
        return rc;
    }
}
