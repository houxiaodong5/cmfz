package com.baizhi.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/4.
 */
public class Chapter {
    private Integer id;
    private String title;
    private String c_size;//大小
    private String duration;//时长
    private String downPath;
    private Date uploadDate;
    private Integer p_id;

    public Chapter() {
    }

    public Chapter(String title, String c_size, String duration, String downPath, Integer p_id) {
        this.title = title;
        this.c_size = c_size;
        this.duration = duration;
        this.downPath = downPath;
        this.p_id = p_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getC_size() {
        return c_size;
    }

    public void setC_size(String c_size) {
        this.c_size = c_size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", c_size='" + c_size + '\'' +
                ", duration='" + duration + '\'' +
                ", downPath='" + downPath + '\'' +
                ", uploadDate=" + uploadDate +
                ", p_id=" + p_id +
                '}';
    }
}