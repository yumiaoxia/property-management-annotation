package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 小区公告表
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("bulletin")
public class Bulletin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小区公告的编号
     */
    @TableId("bulletin_id")
    private String bulletinId;

    /**
     * 小区公告的标题
     */
    @TableField("title")
    private String title;

    /**
     * 小区公告的发布时间
     */
    @TableField("date")
    private LocalDateTime date;

    /**
     * 小区公告的具体内容
     */
    @TableField("content")
    private String content;


    public String getBulletinId() {
        return bulletinId;
    }

    public void setBulletinId(String bulletinId) {
        this.bulletinId = bulletinId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Bulletin{" +
                "bulletinId=" + bulletinId +
                ", title=" + title +
                ", date=" + date +
                ", content=" + content +
                "}";
    }
}
