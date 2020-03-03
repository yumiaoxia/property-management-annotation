package com.example.property.management.web.dto;

import com.example.property.management.entity.Tenant;
import com.itsherman.dto.assembler.annotations.DtoModel;

@DtoModel(from = Tenant.class)
public interface TenantDto {

    /**
     * 租客的身份证号
     */
    String getTenantId();

    /**
     * 租客的姓名
     */
    String getTenantName();

    /**
     * 租客的电话号码
     */
    String getTenantPhone();

    /**
     * 租客的性别
     */
    String getTenantSex();

    /**
     * 房号
     */
    String getHouseNum();

    /**
     * 业主姓名
     */
    String getOwnerName();

}
