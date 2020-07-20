package com.zhj.springcloud.service;

import com.zhj.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @PackageName:com.zhj.springcloud.service
 * @ClassName:DeptClientServiceFallbackFactory
 * @auter: 朱慧杰
 * @date:2020/7/20 0020 9:57
 **/
// 降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(long id) {
                return new Dept()
                        .setDeptNo(id)
                        .setDeptName("id = " + id + ",客户端提供的降级信息：这个服务可能提供了一些重要信息，由于一些突发事件，致使服务关闭，null---@Hystrix")
                        .setDb_source("no this id in database");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
