package com.xiaozhengkeji.blog.entitys;

import java.util.Date;

public class DocEntity {
    private Integer id;
    private String tabname;
    private String docclass;
    private String doctext;
    private Integer dj;
    private Integer ll;
    private Date date;

    @Override
    public String toString() {
        return "DocEntity{" +
                "id=" + id +
                ", tabname='" + tabname + '\'' +
                ", docclass='" + docclass + '\'' +
                ", doctext='" + doctext + '\'' +
                ", dj=" + dj +
                ", ll=" + ll +
                ", date=" + date +
                '}';
    }

    public DocEntity(Integer id, String tabname, String docclass, String doctext, Integer dj, Integer ll, Date date) {
        this.id = id;
        this.tabname = tabname;
        this.docclass = docclass;
        this.doctext = doctext;
        this.dj = dj;
        this.ll = ll;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTabname() {
        return tabname;
    }

    public void setTabname(String tabname) {
        this.tabname = tabname;
    }

    public String getDocclass() {
        return docclass;
    }

    public void setDocclass(String docclass) {
        this.docclass = docclass;
    }

    public String getDoctext() {
        return doctext;
    }

    public void setDoctext(String doctext) {
        this.doctext = doctext;
    }

    public Integer getDj() {
        return dj;
    }

    public void setDj(Integer dj) {
        this.dj = dj;
    }

    public Integer getLl() {
        return ll;
    }

    public void setLl(Integer ll) {
        this.ll = ll;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
