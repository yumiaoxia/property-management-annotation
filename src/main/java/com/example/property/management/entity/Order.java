package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("order")
public class Order implements Serializable {

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
     * 下订单的时间
     */
    @TableField("date")
    private String date;

    /**
     * 房号
     */
    @TableField("house_num")
    private String houseNum;

    /**
     * 预约项目的具体内容
     */
    @TableField("order_content")
    private String orderContent;

    /**
     * 预约项目的完成状态
     */
    @TableField("state")
    private String state;


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type=" + type +
                ", date=" + date +
                ", houseNum=" + houseNum +
                ", orderContent=" + orderContent +
                ", state=" + state +
                "}";
    }
}
