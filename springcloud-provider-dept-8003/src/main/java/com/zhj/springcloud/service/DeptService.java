package com.zhj.springcloud.service;

import com.zhj.springcloud.pojo.Dept;

import java.util.List;

/**
 * @PackageName:com.zhj.springcloud.service
 * @ClassName:DeptService
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 11:06
 **/
public interface DeptService {

    boolean addDept(Dept dept);

    Dept queryById(long id);

    List<Dept> queryAll();

}
