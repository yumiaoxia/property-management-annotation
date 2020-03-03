package com.example.property.management.web.command;

import javax.validation.constraints.NotBlank;

public class OwnerCreate {

    /**
     * ID
     */
    @NotBlank
    private String houseNumber;

    /**
     * 业主的姓名
     */
    private String ownerName;

    /**
     * 业主的性别
     */
    private String ownerSex;

    /**
     * 业主的电话号码
     */
    private String ownerPhone;

    /**
     * 业主登录的密码
     */
    private String ownerPass;

    /**
     * 业主所需缴交的物业费
     */
    private String propertyFee;

    /**
     * 业主所需缴交的停车费
     */
    private String parkingFee;

    /**
     * 是否支付 未支付 已支付
     */
    private String paymentStatus;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSex() {
        return ownerSex;
    }

    public void setOwnerSex(String ownerSex) {
        this.ownerSex = ownerSex;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerPass() {
        return ownerPass;
    }

    public void setOwnerPass(String ownerPass) {
        this.ownerPass = ownerPass;
    }

    public String getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(String propertyFee) {
        this.propertyFee = propertyFee;
    }

    public String getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(String parkingFee) {
        this.parkingFee = parkingFee;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
