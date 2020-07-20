package com.zhj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @PackageName:com.zhj.springcloud
 * @ClassName:ConfigServer_3344
 * @auter: 朱慧杰
 * @date:2020/7/20 0020 19:11
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigServer_3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_3344.class, args);
    }

}
