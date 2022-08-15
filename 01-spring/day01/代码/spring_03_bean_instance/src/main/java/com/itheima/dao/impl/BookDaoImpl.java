package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {
    /**
     * 使用构造方法实例化bean 需要无参构造方法
     * spring自动生成所有涉及的bean 所以后面运行其他文件也会出现这个构造方法的打印值
     */
    public BookDaoImpl() {
        System.out.println("book dao constructor is running ....");
    }

    public void save() {
        System.out.println("book dao save ...");
    }

}
