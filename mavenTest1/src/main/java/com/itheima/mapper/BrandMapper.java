package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    public List<Brand> selectAll();
    Brand selectById(int id);

    /**
     * 条件查询 三种参数接收方式
     * 1.散装参数：方法中若有多个参数 需要使用@Param("SQL参数占位符名称")要严格对应
     * 2.对象参数： 对象的属性名要和参数占位符严格对应
     * 3.map集合参数：
     * @param status
     * @param companyname
     * @param brandname
     * @return
     */
    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName") String companyname,@Param("brandName") String brandname);
    List<Brand> selectByCondition1(Brand brand);
    List<Brand> selectByCondition2(Map map);

    List<Brand> selectByCondition3(Map map);
    List<Brand> selectByConditionSingle(Brand brand);//单条件动态查询
    void add(Brand brand);
}
