package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForName {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //spring默认生成单例 对象复用
        BookService bookService1 = (BookService) ctx.getBean("service");
        BookService bookService = (BookService) ctx.getBean("service");
        System.out.println(bookService);
        System.out.println(bookService1);
        bookService.save();
    }
}
