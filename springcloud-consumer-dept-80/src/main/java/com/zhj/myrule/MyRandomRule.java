package com.zhj.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @PackageName:com.zhj.myrule
 * @ClassName:MyRandomRule
 * @auter: 朱慧杰
 * @date:2020/7/19 0019 22:10
 **/
public class MyRandomRule extends AbstractLoadBalancerRule {

    // 每个服务，访问3次，换下一个服务

    // total=0 默认为0 等于3 指向下一个
    // index=0 默认为0 total=3 index=index+1

    private int total = 0;
    private int index = 0;

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                /*int index = this.chooseRandomInt(serverCount);
                server = (Server)upList.get(index);*/
                // 自定义算法
                if (total<3) {
                    server = upList.get(index);
                    total++;
                } else {
                    total = 0;
                    index++;
                    if (index>upList.size()) {
                        index = 0;
                    }
                    upList.get(index);
                }

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
