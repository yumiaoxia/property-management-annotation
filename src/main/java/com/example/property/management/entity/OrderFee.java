package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 各项费用详情
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("order_fee")
public class OrderFee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 家政/维修预约项目类型
     */
    @TableField("type")
    private String type;

    /**
     * 预约项目费用
     */
    @TableField("fee")
    private String fee;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "OrderFee{" +
                "id=" + id +
                ", type=" + type +
                ", fee=" + fee +
                "}";
    }
}
