package com.huowolf.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.huowolf.mapper.TOrderMapper;
import com.huowolf.model.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @创建人：王小伟
 * @创建时间： 2019/10/9
 * @描述：
 */
@Service
public class OrderService {

    @Autowired
    private TOrderMapper tOrderMapper;

    //默认就是master数据源
    public void insert(TOrder tOrder){
        tOrderMapper.insert(tOrder);
    }

    @DS("master")
    public void insertToMaster(TOrder tOrder){
        tOrderMapper.insert(tOrder);
    }

    @DS("slave_1")
    public void insertToSlave1(TOrder tOrder){
        tOrderMapper.insert(tOrder);
    }
}
