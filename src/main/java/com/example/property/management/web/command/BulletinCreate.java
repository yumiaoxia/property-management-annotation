package com.example.property.management.web.command;


import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class BulletinCreate {

    @Size(max = 10)
    private String bulletinId;
    /**
     * 小区公告的标题
     */
    @Size(max = 50)
    private String title;

    /**
     * 小区公告的发布时间
     */
    private LocalDateTime date;

    /**
     * 小区公告的具体内容
     */
    @Size(max = 500)
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
}
