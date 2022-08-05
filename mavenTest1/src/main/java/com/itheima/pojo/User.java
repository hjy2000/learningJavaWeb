package com.itheima.pojo;

import org.junit.jupiter.api.Test;

public class User {
    private int id;
    private String username;
    private String password;
    private String gender;
    private String addr;

    @Override
    public String toString() {
        return id+username+password+gender+addr;
    }

    @Test
    public void test1()
    {
        System.out.println();
    }
}
