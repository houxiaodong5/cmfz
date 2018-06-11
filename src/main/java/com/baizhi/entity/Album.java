package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/3
 */
public class Album implements Serializable {
    private Integer id;
    private String title;
    private  String coverImg;
    private Integer a_count;
    private  Integer score;
    private  String author;
    private  String reciter;   //朗诵者
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date publishDate;

    public Album() {
    }

    public Album(String title, String coverImg, Integer a_count, Integer score, String author, String reciter, String brief) {
        this.title = title;
        this.coverImg = coverImg;
        this.a_count = a_count;
        this.score = score;
        this.author = author;
        this.reciter = reciter;
        this.brief = brief;
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

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getA_count() {
        return a_count;
    }

    public void setA_count(Integer a_count) {
        this.a_count = a_count;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReciter() {
        return reciter;
    }

    public void setReciter(String reciter) {
        this.reciter = reciter;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", a_count='" + a_count + '\'' +
                ", score='" + score + '\'' +
                ", author='" + author + '\'' +
                ", reciter='" + reciter + '\'' +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
// http://localhost:9999/cmfz/album/add.do?title=轮播图&iconCls=icon-tip&parent_id=1


