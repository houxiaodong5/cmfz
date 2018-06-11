package com.baizhi.entity;

/**
 * Created by Administrator on 2018/5/31.
 */
public class FileParam {
    private String url;
    private String oldName;

    public FileParam() {
    }

    public FileParam(String url, String oldName) {
        this.url = url;
        this.oldName = oldName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    @Override
    public String toString() {
        return "FileParam{" +
                "url='" + url + '\'' +
                ", oldName='" + oldName + '\'' +
                '}';
    }
}
