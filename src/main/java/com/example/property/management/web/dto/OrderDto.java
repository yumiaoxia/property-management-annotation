package com.example.property.management.web.dto;

import com.example.property.management.entity.Order;
import com.itsherman.dto.assembler.annotations.DtoModel;

@DtoModel(from = Order.class)
public interface OrderDto {

    /**
     * ID
     */
    Integer getId();

    /**
     * 家政/维修预约项目类型
     */
    String getType();

    /**
     * 下订单的时间
     */
    String getDate();

    /**
     * 房号
     */
    String getHouseNum();

    /**
     * 预约项目的具体内容
     */
    String getOrderContent();

    /**
     * 预约项目的完成状态
     */
    String getState();
}
