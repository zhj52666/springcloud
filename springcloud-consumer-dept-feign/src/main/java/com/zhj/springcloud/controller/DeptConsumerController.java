package com.zhj.springcloud.controller;

import com.zhj.springcloud.pojo.Dept;
import com.zhj.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @PackageName:com.zhj.springcloud.controller
 * @ClassName:DeptConsumerController
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 11:48
 **/
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService service = null;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return service.queryById(id);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
       return service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return service.queryAll();
    }

}
