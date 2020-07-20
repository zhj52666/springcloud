package com.zhj.springcloud.service;

import com.zhj.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {


    /**
     * 服务熔断和服务降级
     * 服务熔断：
     * 服务端~ 某个服务异常或者超时，引起熔断~  类似保险丝
     *
     * 服务降级：
     * 客户端~ 从整体网站考虑，当某个服务熔断或者关闭之后，服务将不再被调用~
     * 此时在客户端，我们可以准备一个FallbackFactory ,返回一个默认的缺省值，整体的服务水平下降~ 但是可用，不会完全挂掉
     * @param dept
     * @return
     */

    @PostMapping("/dept/add")
    boolean addDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    List<Dept> queryAll();

}
