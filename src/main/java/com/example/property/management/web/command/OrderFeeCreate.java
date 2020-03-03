package com.example.property.management.web.command;

import org.hibernate.validator.constraints.Length;

public class OrderFeeCreate {

    /**
     * 家政/维修预约项目类型
     */
    @Length(max = 10)
    private String type;

    /**
     * 预约项目费用
     */
    @Length(max = 6)
    private String fee;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
