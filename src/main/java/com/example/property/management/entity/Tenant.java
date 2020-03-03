package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 租客信息表
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("tenant")
public class Tenant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租客的身份证号
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 租客的姓名
     */
    @TableField("tenant_name")
    private String tenantName;

    /**
     * 租客的电话号码
     */
    @TableField("tenant_phone")
    private String tenantPhone;

    /**
     * 租客的性别
     */
    @TableField("tenant_sex")
    private String tenantSex;

    /**
     * 房号
     */
    @TableId("house_num")
    private String houseNum;

    /**
     * 业主姓名
     */
    @TableField("owner_name")
    private String ownerName;


    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

    public String getTenantSex() {
        return tenantSex;
    }

    public void setTenantSex(String tenantSex) {
        this.tenantSex = tenantSex;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantId=" + tenantId +
                ", tenantName=" + tenantName +
                ", tenantPhone=" + tenantPhone +
                ", tenantSex=" + tenantSex +
                ", houseNum=" + houseNum +
                ", ownerName=" + ownerName +
                "}";
    }
}
