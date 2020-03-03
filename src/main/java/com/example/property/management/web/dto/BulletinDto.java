package com.example.property.management.web.dto;

import com.example.property.management.entity.Bulletin;
import com.itsherman.dto.assembler.annotations.DtoModel;

import java.time.LocalDateTime;

@DtoModel(from = Bulletin.class)
public interface BulletinDto {

    /**
     * 小区公告的编号
     */
    String getBulletinId();

    /**
     * 小区公告的标题
     */
    String getTitle();

    /**
     * 小区公告的发布时间
     */
    LocalDateTime getDate();

    /**
     * 小区公告的具体内容
     */
    String getContent();
}
