package com.example.property.management.web.dto;

import com.example.property.management.entity.PropertyAdmin;
import com.itsherman.dto.assembler.annotations.DtoModel;
import com.itsherman.dto.assembler.annotations.DtoProperty;

@DtoModel(from = PropertyAdmin.class)
public interface ProAdminDto {
    /**
     * 管理员工号，也是登录系统的账号
     */
    @DtoProperty("adminId")
    String getId();

    /**
     * 管理员的的登录密码
     */
    @DtoProperty("proadminPass")
    String getPass();

    /**
     * 管理员的姓名
     */
    @DtoProperty("proadminName")
    String getName();

    /**
     * 管理员的性别
     */
    @DtoProperty("proadminSex")
    String getSex();

    /**
     * 管理员的电话号码
     */
    @DtoProperty("proadminPhone")
    String getPhone();

    /**
     * 管理员的职称
     */

    String getPosition();

    /**
     * 管理员的身份证号
     */
    String getIdentity();
}
