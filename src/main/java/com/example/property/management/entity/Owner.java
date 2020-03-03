package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 业主信息表
 *
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("owner")
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("house_number")
    private String houseNumber;

    /**
     * 业主的姓名
     */
    @TableField("owner_name")
    private String ownerName;

    /**
     * 业主的性别
     */
    @TableField("owner_sex")
    private String ownerSex;

    /**
     * 业主的电话号码
     */
    @TableField("owner_phone")
    private String ownerPhone;

    /**
     * 业主登录的密码
     */
    @TableField("owner_pass")
    private String ownerPass;

    /**
     * 业主所需缴交的物业费
     */
    @TableField("property_fee")
    private String propertyFee;

    /**
     * 业主所需缴交的停车费
     */
    @TableField("parking_fee")
    private String parkingFee;

    /**
     * 是否支付 未支付 已支付
     */
    @TableField("payment_status")
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

    @Override
    public String toString() {
        return "Owner{" +
                "houseNumber=" + houseNumber +
                ", ownerName=" + ownerName +
                ", ownerSex=" + ownerSex +
                ", ownerPhone=" + ownerPhone +
                ", ownerPass=" + ownerPass +
                ", propertyFee=" + propertyFee +
                ", parkingFee=" + parkingFee +
                ", paymentStatus=" + paymentStatus +
                "}";
    }
}
