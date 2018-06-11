package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public class Menu implements Serializable {
    private Integer id;
    private String title;
    private String iconCls;
    private String parent_id;
    private String url;
    private List<Menu> children;

    public Menu() {
    }

    public Menu(String title, String iconCls, String parent_id, String url) {
        this.title = title;
        this.iconCls = iconCls;
        this.parent_id = parent_id;
        this.url = url;
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}
// http://localhost:9999/cmfz/menu/add.do?title=轮播图管理&iconCls=icon-man
// http://localhost:9999/cmfz/menu/add.do?title=轮播图&iconCls=icon-tip&parent_id=1
// http://localhost:9999/cmfz/menu/add.do?title=吉祥妙音&iconCls=icon-reload
// http://localhost:9999/cmfz/menu/add.do?title=甘露妙宝&iconCls=icon-cut
// http://localhost:9999/cmfz/menu/add.do?title=功课记录&iconCls=icon-lock
// http://localhost:9999/cmfz/menu/add.do?title=用户管理&iconCls=icon-ok
// http://localhost:9999/cmfz/menu/add.do?title=甘露明珠&iconCls=icon-ok&parent_id=10&url=/datagrid/album.jsp