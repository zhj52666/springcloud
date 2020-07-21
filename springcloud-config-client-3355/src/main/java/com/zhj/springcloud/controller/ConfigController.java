package com.zhj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:com.zhj.springcloud.controller
 * @ClassName:ConfigController
 * @auter: 朱慧杰
 * @date:2020/7/21 0021 9:15
 **/
@RestController
public class ConfigController {

    @Value("${spring.application.name")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        return "applicationName: " + applicationName +
                "eurekaServer: " + eurekaServer +
                "port: " + port;
    }

}
