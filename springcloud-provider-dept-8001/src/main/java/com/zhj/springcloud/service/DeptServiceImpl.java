package com.zhj.springcloud.service;

import com.zhj.springcloud.mapper.DeptMapper;
import com.zhj.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName:com.zhj.springcloud.service
 * @ClassName:DeptServiceImpl
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 11:06
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept queryById(long id) {
        return deptMapper.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
