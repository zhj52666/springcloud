package com.zhj.myrule;

import com.netflix.loadbalancer.IRule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName:com.zhj.springcloud.config
 * @ClassName:MyRule
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 21:58
 **/
@Configuration
public class MyRule {

    @Bean
    public IRule zhjRule() {
        // return new MyRandomRule(); 自定义负载均衡
        return new RandomRule();
    }

}
