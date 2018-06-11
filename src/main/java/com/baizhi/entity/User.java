package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baizhi.poi.UserAnnoation;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/29.
 */
public class User implements Serializable {
    @UserAnnoation(name = "编号")
    private Integer id;
    @UserAnnoation(name="手机号")
    private String phoneNum;
    @UserAnnoation(name="用户名")
    private String username;
    @UserAnnoation(name="密码")
    private String password;
    @UserAnnoation(name="密钥")
    private String salt;
    @UserAnnoation(name="法名")
    private String dharmaName;//法名
    @UserAnnoation(name="省份")
    private String province;
    @UserAnnoation(name="市区")
    private String city;
    @UserAnnoation(name="所在地")
    private String location;
    @UserAnnoation(name="性别")
    private String sex;
    @UserAnnoation(name="签名")
    private String sign;//签名
    @UserAnnoation(name="头像")
    private String headPlc;
    @UserAnnoation(name="状态")
    private String status;
    @UserAnnoation(name="注册时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date regDate;

    public User() {
    }

    public User(String phoneNum, String username, String password, String dharmaName, String province, String city, String sex, String sign, String headPlc, String status) {
        this.phoneNum = phoneNum;
        this.username = username;
        this.password = password;
        this.dharmaName = dharmaName;
        this.province = province;
        this.city = city;
        this.sex = sex;
        this.sign = sign;
        this.headPlc = headPlc;
        this.status = status;
    }

    public User(String phoneNum, String password, String salt, Date regDate) {
        this.phoneNum = phoneNum;
        this.password = password;
        this.salt = salt;
        this.regDate = regDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHeadPlc() {
        return headPlc;
    }

    public void setHeadPlc(String headPlc) {
        this.headPlc = headPlc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getLocation() {
        return this.province+this.city;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sex='" + sex + '\'' +
                ", sign='" + sign + '\'' +
                ", headPlc='" + headPlc + '\'' +
                ", status='" + status + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
