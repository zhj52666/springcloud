package com.zhj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhj.springcloud.pojo.Dept;
import com.zhj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PackageName:com.zhj.springcloud.controller
 * @ClassName:DeptController
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 11:09
 **/
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {

        Dept dept = deptService.queryById(id);

        if (dept == null) {
            throw new RuntimeException("id = " + id + ",不存在该用户，或者信息无法找到！！！");
        }

        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptNo(id)
                .setDeptName("id = " + id + ",不存在该用户，null---@Hystrix")
                .setDb_source("no this id in database");
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.queryAll();
    }


}
