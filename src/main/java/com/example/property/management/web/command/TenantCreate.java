package com.example.property.management.web.command;

import javax.validation.constraints.NotBlank;

public class TenantCreate {

    /**
     * 租客的身份证号
     */
    @NotBlank
    private String tenantId;

    /**
     * 租客的姓名
     */
    private String tenantName;

    /**
     * 租客的电话号码
     */
    private String tenantPhone;

    /**
     * 租客的性别
     */
    private String tenantSex;

    /**
     * 房号
     */
    @NotBlank
    private String houseNum;

    /**
     * 业主姓名
     */
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
}
