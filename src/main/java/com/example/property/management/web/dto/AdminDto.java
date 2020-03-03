package com.example.property.management.web.dto;

import com.example.property.management.entity.Admin;
import com.itsherman.dto.assembler.annotations.DtoModel;

@DtoModel(from = Admin.class)
public interface AdminDto {

    /**
     * 管理员工号，也是登录系统的账号
     */
    String getAdminId();

    /**
     * 管理员的的登录密码
     */
    String getAdminPass();

    /**
     * 管理员的姓名
     */
    String getAdminName();

    /**
     * 管理员的性别
     */
    String getAdminSex();

    /**
     * 管理员的电话号码
     */
    String getAdminPhone();

    /**
     * 管理员的职称
     */
    String getPosition();

    /**
     * 管理员的身份证号
     */
    String getIdentity();
}
