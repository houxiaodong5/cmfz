package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/29.
 */
public class Admin implements Serializable {
    private Integer id;
    private String name;
    private String password;

    public Admin() {

    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
