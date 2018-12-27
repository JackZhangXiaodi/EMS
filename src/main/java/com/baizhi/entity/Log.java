package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Log implements Serializable {
    private String id;
    private String uname;//操作用户的名字
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;//操作时间
    private String article;//操作内容
    private String result;//修改结果

    public Log() {
        super();
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", uname='" + uname + '\'' +
                ", time=" + time +
                ", article='" + article + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id) &&
                Objects.equals(uname, log.uname) &&
                Objects.equals(time, log.time) &&
                Objects.equals(article, log.article) &&
                Objects.equals(result, log.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uname, time, article, result);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Log(String id, String uname, Date time, String article, String result) {
        this.id = id;
        this.uname = uname;
        this.time = time;
        this.article = article;
        this.result = result;
    }
}
