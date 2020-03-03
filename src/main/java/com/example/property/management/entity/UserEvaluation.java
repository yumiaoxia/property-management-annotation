package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单评价表
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("user_evaluation")
public class UserEvaluation implements Serializable {

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
     * 用户评价内容
     */
    @TableField("evaluation_content")
    private String evaluationContent;

    @TableField("date")
    private LocalDateTime date;

    @TableField("house_num")
    private String houseNum;

    @TableField("order_content")
    private String orderContent;

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

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
        return "UserEvaluation{" +
                "id=" + id +
                ", type=" + type +
                ", evaluationContent=" + evaluationContent +
                ", date=" + date +
                ", houseNum=" + houseNum +
                ", orderContent=" + orderContent +
                ", state=" + state +
                "}";
    }
}
