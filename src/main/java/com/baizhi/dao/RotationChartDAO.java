package com.baizhi.dao;
import java.util.List;
import com.baizhi.entity.RotationChart;

/**
 * Created by Administrator on 2018/5/29.
 */
public interface RotationChartDAO {
    void insert(RotationChart rotationChart);
    List<RotationChart>  queryAll();
    void delete( Integer id);
    void update(RotationChart update);
}
