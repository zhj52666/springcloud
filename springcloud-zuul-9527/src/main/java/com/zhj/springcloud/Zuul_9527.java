package com.zhj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @PackageName:com.zhj.springcloud
 * @ClassName:Zuul_9527
 * @auter: 朱慧杰
 * @date:2020/7/20 0020 18:06
 **/
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527 {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527.class, args);
    }

}
