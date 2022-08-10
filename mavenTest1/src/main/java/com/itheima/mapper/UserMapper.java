package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from tb_user;")//注解开发
    List <User> selectAll();
    User selectById(int id);
    /*
    我们在接口方法中定义多个参数，Mybatis 会将这些参数封装成 Map 集合对象，值就是参数值，而键在没有使用 `@Param` 注解时有以下命名规则：
    * 以 arg 开头  ：第一个参数就叫 arg0，第二个参数就叫 arg1，以此类推。如：
      > map.put("arg0"，参数值1);
      > map.put("arg1"，参数值2);
    * 以 param 开头 ： 第一个参数就叫 param1，第二个参数就叫 param2，依次类推。如：
      > map.put("param1"，参数值1);
      > map.put("param2"，参数值2);
     */
    User select(String username,String password);
}
