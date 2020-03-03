package com.example.property.management.web.dto;

import com.example.property.management.entity.Owner;
import com.itsherman.dto.assembler.annotations.DtoModel;

@DtoModel(from = Owner.class)
public interface OwnerDto {

    String getHouseNumber();

    String getOwnerName();

    /**
     * 业主的性别
     */
    String getOwnerSex();

    /**
     * 业主的电话号码
     */
    String getOwnerPhone();

    /**
     * 业主登录的密码
     */
    String getOwnerPass();

    /**
     * 业主所需缴交的物业费
     */
    String propertyFee();

    /**
     * 业主所需缴交的停车费
     */
    String getParkingFee();

    /**
     * 是否支付 未支付 已支付
     */
    String getPaymentStatus();

}
