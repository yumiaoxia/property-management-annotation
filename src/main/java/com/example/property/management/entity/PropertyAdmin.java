package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("property_admin")
public class PropertyAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员工号，也是登录系统的账号
     */
    @TableId("proadmin_id")
    private String proadminId;

    /**
     * 管理员的的登录密码
     */
    @TableField("proadmin_pass")
    private String proadminPass;

    /**
     * 管理员的姓名
     */
    @TableField("proadmin_name")
    private String proadminName;

    /**
     * 管理员的性别
     */
    @TableField("proadmin_sex")
    private String proadminSex;

    /**
     * 管理员的电话号码
     */
    @TableField("proadmin_phone")
    private String proadminPhone;

    /**
     * 管理员的职称
     */
    @TableField("position")
    private String position;

    /**
     * 管理员的身份证号
     */
    @TableField("identity")
    private String identity;


    public String getProadminId() {
        return proadminId;
    }

    public void setProadminId(String proadminId) {
        this.proadminId = proadminId;
    }

    public String getProadminPass() {
        return proadminPass;
    }

    public void setProadminPass(String proadminPass) {
        this.proadminPass = proadminPass;
    }

    public String getProadminName() {
        return proadminName;
    }

    public void setProadminName(String proadminName) {
        this.proadminName = proadminName;
    }

    public String getProadminSex() {
        return proadminSex;
    }

    public void setProadminSex(String proadminSex) {
        this.proadminSex = proadminSex;
    }

    public String getProadminPhone() {
        return proadminPhone;
    }

    public void setProadminPhone(String proadminPhone) {
        this.proadminPhone = proadminPhone;
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
        return "PropertyAdmin{" +
                "proadminId=" + proadminId +
                ", proadminPass=" + proadminPass +
                ", proadminName=" + proadminName +
                ", proadminSex=" + proadminSex +
                ", proadminPhone=" + proadminPhone +
                ", position=" + position +
                ", identity=" + identity +
                "}";
    }
}
