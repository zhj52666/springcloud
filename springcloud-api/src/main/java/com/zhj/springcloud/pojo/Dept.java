package com.zhj.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @PackageName:com.zhj.springcloud.pojo
 * @ClassName:Dept
 * @auter: 朱慧杰
 * @date:2020/7/18 0018 18:13
 **/
@Data
@NoArgsConstructor
@Accessors(chain = true)  // 链式写法
public class Dept implements Serializable {

    private Long deptNo;
    private String deptName;

    // 数据存在哪个数据库的字段~ 微服务，一个服务对应一个数据库，同一个信息可能存在不同数据库
    private String db_source;

    public Dept(String deptName) {
        this.deptName = deptName;
    }

    /*
    链式写法：
    Dept dept = new Dept();
    dept.setDeptNo().setDeptName();
    */

}
