package com.baizhi.service;

import com.baizhi.entity.RotationChart;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public interface RotationChartService {
    void insert(RotationChart rotationChart);
    List<RotationChart> queryAll();
    void delete(Integer id);
    void update(RotationChart rotationChart);
}
