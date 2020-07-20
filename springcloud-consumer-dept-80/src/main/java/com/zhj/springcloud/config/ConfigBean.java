package com.zhj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @PackageName:com.zhj.springcloud.config
 * @ClassName:ConfigBean
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 11:53
 **/
@Configuration
public class ConfigBean {

    // 配置负载均衡
    // IRule
    // RoundRobinRule 轮询
    // RandomRule 随机
    // AvailabilityFilteringRule 会先过滤掉，跳闸，访问故障的服务，对剩下的做轮询
    // RetryRule 会先按照轮询获取服务，如果服务失败，则会在指定时间内进行，重试
    @Bean
    @LoadBalanced  //Ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /*@Bean
    public IRule myRule() {
        return new RandomRule();
    }*/

}
