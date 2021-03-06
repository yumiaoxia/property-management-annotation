package com.example.property.management.web.dto;

import com.example.property.management.entity.Admin;
import com.itsherman.dto.assembler.annotations.DtoModel;
import com.itsherman.dto.assembler.annotations.DtoProperty;

@DtoModel(from = Admin.class)
public interface AdminDto {

    /**
     * 管理员工号，也是登录系统的账号
     */
    @DtoProperty("adminId")
    String getId();

    /**
     * 管理员的的登录密码
     */
    @DtoProperty("adminPass")
    String getPass();

    /**
     * 管理员的姓名
     */
    @DtoProperty("adminName")
    String getName();

    /**
     * 管理员的性别
     */
    @DtoProperty("adminSex")
    String getSex();

    /**
     * 管理员的电话号码
     */
    @DtoProperty("adminPhone")
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
