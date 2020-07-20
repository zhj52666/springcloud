package com.zhj.springcloud.mapper;

import com.zhj.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept queryById(long id);

    List<Dept> queryAll();

}
