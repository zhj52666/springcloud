package com.zhj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PackageName:com.zhj.springcloud
 * @ClassName:DeptConsumerFeign
 * @auter: 朱慧杰
 * @date:2020/7/20 0020 8:19
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zhj.springcloud"})
public class DeptConsumerFeign {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign.class, args);
    }

}
