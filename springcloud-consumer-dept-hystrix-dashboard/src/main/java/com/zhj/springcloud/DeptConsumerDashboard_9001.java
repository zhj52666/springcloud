package com.zhj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @PackageName:com.zhj.springcloud
 * @ClassName:DeptComsumerDashboard_9001
 * @auter: 朱慧杰
 * @date:2020/7/20 0020 10:32
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerDashboard_9001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard_9001.class, args);
    }

}
