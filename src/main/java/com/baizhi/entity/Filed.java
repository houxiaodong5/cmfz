package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/5.
 */
public class Filed implements Serializable{
    private String  text;
    private String id;

    public Filed(String text, String id) {
        this.text = text;
        this.id = id;
    }

    public Filed() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Filed{" +
                "text='" + text + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
