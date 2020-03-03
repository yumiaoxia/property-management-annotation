package com.example.property.management.entity;

import java.io.Serializable;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员工号，也是登录系统的账号
     */
    private String adminId;

    /**
     * 管理员的的登录密码
     */
    private String adminPass;

    /**
     * 管理员的姓名
     */
    private String adminName;

    /**
     * 管理员的性别
     */
    private String adminSex;

    /**
     * 管理员的电话号码
     */
    private String adminPhone;

    /**
     * 管理员的职称
     */
    private String position;

    /**
     * 管理员的身份证号
     */
    private String identity;


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminPass=" + adminPass +
                ", adminName=" + adminName +
                ", adminSex=" + adminSex +
                ", adminPhone=" + adminPhone +
                ", position=" + position +
                ", identity=" + identity +
                "}";
    }
}
