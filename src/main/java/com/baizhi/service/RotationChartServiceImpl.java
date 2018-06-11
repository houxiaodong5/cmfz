package com.baizhi.service;

import com.baizhi.dao.RotationChartDAO;
import com.baizhi.entity.RotationChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
@Service
@Transactional//  事务控制
public class RotationChartServiceImpl implements  RotationChartService {
    @Autowired
    private RotationChartDAO rotationChartDAO;
    public void insert(RotationChart rotationChart) {
        rotationChartDAO.insert(rotationChart);
    }
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly = true)
    public List<RotationChart> queryAll() {
        List<RotationChart> rc=rotationChartDAO.queryAll();
        return rc;
    }

    public void delete(Integer id) {
        rotationChartDAO.delete(id);

    }
    public void update(RotationChart rotationChart) {
        rotationChartDAO.update(rotationChart);
    }

}
