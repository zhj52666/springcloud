package com.zhj.springcloud;

import com.zhj.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @PackageName:com.zhj.springcloud
 * @ClassName:DeptConsumer_80
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 12:06
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)  // 微服务启动就能加载自定义的Ribbon
public class DeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }

}
