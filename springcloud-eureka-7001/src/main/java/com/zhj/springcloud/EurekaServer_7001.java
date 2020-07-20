package com.zhj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @PackageName:com.zhj.springcloud
 * @ClassName:EurekaServer_7001
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 14:46
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer_7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class, args);
    }

}
